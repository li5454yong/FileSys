package com.fs.controller;


import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fs.entity.Files;
import com.fs.entity.User;
import com.fs.service.FilesService;
import com.sun.org.apache.bcel.internal.generic.GETSTATIC;

@Controller
public class UploadController extends BasicController {

	@Resource
	private FilesService service;
	
	@RequestMapping("upload")
	public String upload(HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String pId = request.getParameter("pId"); //文件所属分类
		User user = getAuthUser();
		Files files = new Files();
		if(user != null){
			CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> t = multiRequest.getFileNames();
			MultipartFile fileDetail = multiRequest.getFile(t.next());
			if (fileDetail != null) {
				String fileName = fileDetail.getOriginalFilename();
				String type = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()).toLowerCase();
				Long size = fileDetail.getSize();
				String path = "D:/FileSys/upload/" + user.getUsername();
				File file = new File(path);
				if(!file.exists()){
					file.mkdirs();
				}
				File localFile = new File(path+"/"+fileName);
				
				//将上传文件写入到指定文件
				try {
					fileDetail.transferTo(localFile);
					
					files.setCategory_id(pId);
					files.setFilename(fileName);
					files.setFilepath(path+"/"+fileName);
					files.setFilesize(getFileSize(size));
					files.setFiletype(type);
					files.setUser_id(user.getId());
					files.setUploadDate(new Date());
					files.setUpd_date(new Date());
					files.setInit_date(new Date());
					files.setIcon_path(getIconPath(type));
					service.save(files);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//非常重要、有了这个想做什么处理都可以
				//fileDetail.getInputStream();
			}
		}else{
			return redirect("toLogin");
		}
		return redirect("toMycenter");
	}
	
	/**
	 * 转换文件大小
	 * @param size
	 * @return
	 */
	public String getFileSize(Long size){
		double d = size/1024.0;
		StringBuilder sb = new StringBuilder();
		if(d>1024){
			double s = size * 100 / (1024.0 * 1024.0) / 100.0;
			DecimalFormat df=new DecimalFormat("#.00");
			sb.append(df.format(s));
			sb.append(" M");
		}else{
			double s = size * 100 / 1024.0/ 100.0;
			DecimalFormat df=new DecimalFormat("#.00");
			sb.append(df.format(s));
			sb.append(" Kb");
		}
		return sb.toString();
	}
	
	
	/**
	 * 根据文件类型获取文件类型的图标
	 * @param type
	 * @return
	 */
	public String getIconPath(String type){
		String path = "";
		switch (type) {
			case "rar": path = "img/rar.png";break;
			case "zip": path = "img/zip.png";break;
			case "ppt": path = "img/pptx_win.png";break;
			case "pptx": path = "img/pptx_win.png";break;
			case "xls": path = "img/xlsx_win.png";break;
			case "jpg": path = "img/jpeg.png";break;
			case "jpeg": path = "img/jpeg.png";break;
			case "png": path = "img/png.png";break;
			case "pdf": path = "img/pdf.png";break;
			case "xlsx": path = "img/xlsx_win.png";break;
			
			default:path = "img/ysj.png";break;
		}
		
		return path;
	}
}
