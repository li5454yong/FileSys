package com.fs.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"publicShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForFile(fileList.get(0), request.getServletContext(), 
					sb.toString(),"publicShareFile.ftl");
			
			param.put("url", "http://localhost:8080/FileSys/publicShare/"+htmlName);
			
			Durl = DwzUtil.getDwz(param);
			
		}else{
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"publicShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForList(fileList,categoryList, request.getServletContext(), 
					sb.toString(),"publicShareFiles.ftl");
			
			param.put("url", "http://localhost:8080/FileSys/publicShare/"+htmlName);
			
			Durl = DwzUtil.getDwz(param);
		}
		shareService.batchEntityByHQL(shareList, Durl);
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
					sb.toString(),"privateShareFile.ftl");
			url = "http://localhost:8080/FileSys/privateShare/"+htmlName;
			param.put("url", url);
			
			Durl = DwzUtil.getDwz(param);
			
		}else{
			String htmlName = UUIDUtil.get8str()+".html";
			StringBuilder sb = new StringBuilder(CreateHtmlUtil.getPath()+"privateShare/");
			sb.append(htmlName);
			//生成静态页面
			CreateHtmlUtil.createHtmlForList(fileList,categoryList, request.getServletContext(), 
					sb.toString(),"privateShareFiles.ftl");
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
}
