package com.fs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Filing;
import com.fs.entity.Share;
import com.fs.entity.ShareList;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;
import com.fs.service.ShareService;
import com.fs.service.UserService;
import com.fs.util.FileUtil;
import com.fs.util.PackFilesUtil;

/**
 * @author lxg
 *
 *         2016年1月19日下午7:59:34
 */
@Controller
@RequestMapping("share")
public class ShareController extends BasicController{

	@Resource
	private FilesService filesService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ShareService shareService;
	
	@Resource
	private UserService servise;

	/**
	 * 分享页面，点击文件夹获取文件夹下级内容
	 * @param pId
	 * @param selfId
	 * @param user_id
	 * @param url
	 * @return
	 */
	@RequestMapping("getnext")
	public @ResponseBody WebMessage getNext(String pId, String selfId,int user_id,String url) {
		try{
			// 加载的文件夹列表
			List<Category> categoryList = categoryService.getCategoryList(pId,
					user_id);
			// 加载的文件列表
			List<Files> fileList = filesService.getFileList(pId, user_id);
			// 加载的浏览导航
			List<Category> parentList = categoryService.getParentList(selfId,
					user_id);
			List<Share> shareList = shareService.getShareList(url);
			
			int i = 0;
			for(Category c : parentList){
				
				for(Share s : shareList){
					if(s.getSelf_id().equals(c.getSelf_id())){
						i++;
					}
				}
			}
			List<Category> parentList1 = parentList.subList(i-1, parentList.size());
			
			String categorys = JSON.toJSONString(categoryList);
 			String files = JSON.toJSONString(fileList);
			String parentes = JSON.toJSONString(parentList1);
			
			return saveSuccess(categorys + "@LXG" + files + "@LXG" + parentes);
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		//return "mycenter/index";
	}


	/**
	 * 文件分享页面  下载文件
	 * @param url
	 * @param user_id
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("download")
	public void download(String url,int user_id,HttpServletResponse response) throws Exception{
		
		User user = servise.getUser(user_id);
		
		OutputStream o = response.getOutputStream();
		byte b[] = new byte[1024];
		
		List<Share> shareList = shareService.getShareList(url);
		
		List<Category> categoryList = new ArrayList<Category>();
		List<List<Category>> l = new ArrayList<List<Category>>();
		List<Files> fileList = new ArrayList<Files>(); 
		
		//获取要 下载的文件夹和文件列表
		for(Share s : shareList){
			if(s.getType() == 1){
				Category category = categoryService.get(s.getF_id());
				categoryList.add(category);
				List<Category> parentList = categoryService.getParentList(category.getSelf_id(),user_id);
				l.add(parentList);
			}else if(s.getType() == 2){
				Files file = filesService.get(s.getF_id());
				fileList.add(file);
			}
		}
		
		//对文件进行打包下载
		if(fileList.size()==1 && categoryList.size() == 0){ //单个文件下载
			Files f = fileList.get(0);
			String name =new String(f.getFilename().getBytes(), "iso-8859-1");
			
			File fileLoad = new File(f.getFilepath());
			response.setHeader("Content-disposition", "attachment;filename="+ name);
			
			response.setContentType(FileUtil.getContentType(f.getFiletype()));
			long fileLength = fileLoad.length();
			String length = String.valueOf(fileLength);
			response.setHeader("Content_Length", length);
			// download the file.
			FileInputStream in = new FileInputStream(fileLoad);
			int n = 0;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n);
			}
		}else{ //非单个文件下载
			List<String> packFile = new ArrayList<String>();
			for(List<Category> l1 : l){
				StringBuilder sb = new StringBuilder("D:/FileSys/upload/" + user.getUsername());
				for(Category category : l1){
					sb.append("/"+category.getTitle());
				}
				packFile.add(sb.toString());
			}
			for(Files f : fileList){
				packFile.add(f.getFilepath());
			}
			
			String fileName = "";
			if(categoryList.size() == 1 && fileList.size() == 0){
				fileName = categoryList.get(0).getTitle()+".zip";
			}else{
				fileName = new Date().getTime()+".zip";
			}
			PackFilesUtil.zip(packFile, "D:/FileSys/download/"+fileName);
			
			
			String name =new String(fileName.getBytes(), "iso-8859-1");
			File fileLoad = new File("D:/FileSys/download/"+fileName);
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			
			response.setContentType("application/zip");
			long fileLength = fileLoad.length();
			String length = String.valueOf(fileLength);
			response.setHeader("Content_Length", length);
			// download the file.
			FileInputStream in = new FileInputStream(fileLoad);
			int n = 0;
			while ((n = in.read(b)) != -1) {
				o.write(b, 0, n);
			}
			o.flush();
		}
		
	}

	/**
	 * 获取用户分享的所有文件（按url分组）
	 * @return
	 */
	@RequestMapping("getShareList")
	public String getShareList(ModelMap map){
		
		User user = getAuthUser();
		if(user == null){
			return redirect("toLogin");
		}
		List<Filing> filingList = filesService.getFiling(user.getId());
		List<Category> tagCloud = categoryService.getCategoryList(null,user.getId());
		List<Share> list1 = shareService.getShareUrlList(user.getId());
		//List<ShareList> list2 = new ArrayList<ShareList>();
		
		List<ShareList> l = new ArrayList<ShareList>();
		
		/*List<Category> categoryList = new ArrayList<Category>();
		List<Files> fileList = new ArrayList<Files>(); */
		
		for(Share s : list1){
			
			List<Category> categoryList = new ArrayList<Category>();
			List<Files> fileList = new ArrayList<Files>(); 
			
			List<Share> list3 = shareService.getShareList1(s.getShareUrl());
			ShareList shareList = new ShareList();
			for(Share s1 : list3){
				if(s1.getType() == 1){
					Category category = categoryService.get(s1.getF_id());
					categoryList.add(category);
				}else if(s1.getType() == 2){
					Files file = filesService.get(s1.getF_id());
					fileList.add(file);
				}
				
			}
			shareList.setCategoryList(categoryList);
			shareList.setFileList(fileList);
			shareList.setUrl(s.getShareUrl());
			shareList.setInit_date(s.getInit_date());
			
			l.add(shareList);
		}
		map.addAttribute("list", l);
		map.addAttribute("filingList", filingList);
		map.addAttribute("tagCloud", tagCloud);
		//String jsonStr = JSON.toJSONString(l);
		//System.out.println(jsonStr);
		return "file/myShare";
	}
}
