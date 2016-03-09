package com.fs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Share;
import com.fs.entity.ShareDate;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;
import com.fs.service.ShareService;
import com.fs.util.CreateHtmlUtil;
import com.fs.util.DwzUtil;
import com.fs.util.FileUtil;
import com.fs.util.PackFilesUtil;
import com.fs.util.UUIDUtil;

/**
 * @author lxg
 *
 * 2015年12月23日下午8:53:05
 */
@Controller
@RequestMapping("files")
public class FileController extends BasicController {
	
	@Resource
	private FilesService filesService;
	@Resource
	private CategoryService categoryService;
	@Resource
	private ShareService shareService;
	/**
	 * 创建公开分享链接
	 * @param share
	 * @return
	 */
	@RequestMapping("paublicShare")
	public @ResponseBody WebMessage paublicShare(String share,HttpServletRequest request){
		User user = getAuthUser();
		
		String shareUrl = UUIDUtil.get8str();
		List<ShareDate> list = JSONArray.parseArray(share, ShareDate.class); //获取页面传递过来的要分享的文件信息

		List<Files> fileList = new ArrayList<Files>(); //要分享的文件，用于生成静态页面
		List<Category> categoryList = new ArrayList<Category>(); //要分享的文件夹，用于生成静态页面
		List<Share> shareList = new ArrayList<Share>();
		
		Map<String,String> param = new HashMap<String, String>();
		String Durl = "";
		Share shareObj;
		for(ShareDate s : list){
			if("category".equals(s.getType())){
				
				Category category = categoryService.get(s.getId());
				categoryList.add(category);
				shareObj = new Share();
				
				shareObj.setF_id(s.getId());
				shareObj.setType(1);
				shareObj.setUser_id(user.getId());
				shareObj.setInit_date(new Date());
				shareObj.setShare_date(new Date());
				shareObj.setUpd_date(new Date());
				shareObj.setSelf_id(category.getSelf_id());
				shareObj.setP_id(category.getP_id());
				
				shareList.add(shareObj);
			}else if("file".equals(s.getType())){
				
				Files file = filesService.get(s.getId());
				fileList.add(file);
				shareObj = new Share();
				shareObj.setF_id(s.getId());
				shareObj.setType(2);
				shareObj.setUser_id(user.getId());
				shareObj.setInit_date(new Date());
				shareObj.setShare_date(new Date());
				shareObj.setUpd_date(new Date());
				shareObj.setCategory_id(file.getCategory_id());
				
				shareList.add(shareObj);
			}
		}
		
		String url = "";
		
		if(fileList.size()==1 && categoryList.size() == 0){
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"publicShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForFile(fileList.get(0), request.getServletContext(), 
					sb.toString(),"publicShareFile.ftl",user.getId(),new Date());
			url = "http://localhost:8080/FileSys/publicShare/"+htmlName;
			param.put("url", url);
			
			Durl = DwzUtil.getDwz(param);
			
		}else{
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"publicShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForList(fileList,categoryList, request.getServletContext(), 
					sb.toString(),"publicShareFiles.ftl",user.getId(),new Date());
			url = "http://localhost:8080/FileSys/publicShare/"+htmlName;
			
			param.put("url", "http://localhost:8080/FileSys/publicShare/"+htmlName);
			
			Durl = DwzUtil.getDwz(param);
		}
		shareService.batchEntityByHQL(shareList, url);
		return saveSuccess(Durl);
	}
	
	/**
	 * 创建私密分享链接
	 * @param share
	 * @return
	 */
	@RequestMapping("privateShare")
	public @ResponseBody WebMessage privateShare(String share,HttpServletRequest request){
		User user = getAuthUser();
		
		String shareUrl = UUIDUtil.get8str();
		String pw = UUIDUtil.get5str();
		List<ShareDate> list = JSONArray.parseArray(share, ShareDate.class);
		
		List<Files> fileList = new ArrayList<Files>();
		List<Category> categoryList = new ArrayList<Category>();
		List<Share> shareList = new ArrayList<Share>();
		
		Map<String,String> param = new HashMap<String, String>();
		String Durl = "";
		String url = "";
		Share shareObj;
		for(ShareDate s : list){
			if("category".equals(s.getType())){
				
				Category category = categoryService.get(s.getId());
				categoryList.add(category);
				shareObj = new Share();
				
				shareObj.setF_id(s.getId());
				shareObj.setType(1);
				shareObj.setUser_id(user.getId());
				shareObj.setInit_date(new Date());
				shareObj.setShare_date(new Date());
				shareObj.setUpd_date(new Date());
				
				shareList.add(shareObj);
			}else if("file".equals(s.getType())){
				Files file = filesService.get(s.getId());
				fileList.add(file);
				shareObj = new Share();
				
				shareObj.setF_id(s.getId());
				shareObj.setType(2);
				shareObj.setUser_id(user.getId());
				shareObj.setInit_date(new Date());
				shareObj.setShare_date(new Date());
				shareObj.setUpd_date(new Date());
				
				shareList.add(shareObj);
			}
		}
		
		if(fileList.size()==1 && categoryList.size() == 0){
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"privateShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForFile(fileList.get(0), request.getServletContext(), 
					sb.toString(),"privateShareFile.ftl",user.getId(),new Date());
			url = "http://localhost:8080/FileSys/privateShare/"+htmlName;
			param.put("url", url);
			
			Durl = DwzUtil.getDwz(param);
			
		}else{
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"privateShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForList(fileList,categoryList, request.getServletContext(), 
					sb.toString(),"privateShareFiles.ftl",user.getId(),new Date());
			url = "http://localhost:8080/FileSys/privateShare/"+htmlName;
			param.put("url", url);
			
			Durl = DwzUtil.getDwz(param);
		}
		shareService.batchEntityByHQL(shareList, url,pw);
		return saveSuccess(Durl+"@LXG"+pw);
	}
	
	/**
	 * 验证私密分享的密码
	 * @return
	 */
	@RequestMapping(value="getPrivateShare")
	public @ResponseBody WebMessage getPrivateShare(String url,String passwd){
		
		int flag = shareService.getPrivateShare(url, passwd);
		
		return saveSuccess(flag);
	}

	/**
	 * 文件下载
	 * @param share
	 * @throws Exception 
	 */
	@RequestMapping("download")
	public void downLoad(String share,HttpServletResponse response) throws Exception {
		//PageContext pageContext = new 
		/*PrintWriter out = response.getWriter();
		out.clearError();*/
		
		User user = getAuthUser();
		
		//PrintWriter o = response.getWriter();
		OutputStream o = response.getOutputStream();
		byte b[] = new byte[1024];
		
		List<ShareDate> list = JSONArray.parseArray(share, ShareDate.class); //获取页面传递过来的要下载的文件信息
		List<Files> fileList = new ArrayList<Files>(); 
		List<Category> categoryList = new ArrayList<Category>();
		List<List<Category>> l = new ArrayList<List<Category>>();
		for(ShareDate s : list){
			if("category".equals(s.getType())){
				
				Category category = categoryService.get(s.getId());
				categoryList.add(category);
				List<Category> parentList = categoryService.getParentList(category.getSelf_id(),user.getId());
				l.add(parentList);
			}else if("file".equals(s.getType())){
				Files file = filesService.get(s.getId());
				fileList.add(file);
			}
		}
		
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
			//File fileLoad=new File("E:\\Java源文件\\MyEclipse项目\\Jade\\src\\com\\qianbaidu\\servlet","DownLoadVideoServlet.java");
			response.setHeader("Content-disposition", "attachment;filename="
					+ name);
			// set the MIME type.
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

	@RequestMapping("testDownload")
	public void testDownload(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		OutputStream o=response.getOutputStream();
	    byte b[]=new byte[1024];
	    //the file to download.
	    File fileLoad=new File("E:\\Java源文件\\MyEclipse项目\\Jade\\src\\com\\qianbaidu\\servlet","DownLoadVideoServlet.java");
	    //the dialogbox of download file.
	    response.setHeader("Content-disposition",
	      "attachment;filename="+"DownLoadVideoServlet.java");
	    //set the MIME type.
	    response.setContentType("application/x-tar");
	    //get the file length.
	    long fileLength=fileLoad.length();
	    String length=String.valueOf(fileLength);
	    response.setHeader("Content_Length",length);
	    //download the file.
	    FileInputStream in=new FileInputStream(fileLoad);
	    int n=0;
	    while((n=in.read(b))!=-1){
	     o.write(b,0,n);
	    }
		
	}
}
