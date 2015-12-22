package com.fs.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;
import com.fs.service.UserService;

@Controller
public class UploadController extends BasicController {

	@Resource
	private FilesService service;
	
	@Resource
	private CategoryService categoryService;
	
	@RequestMapping("upload")
	public void upload(HttpServletRequest request, PrintWriter out){
		String pId = request.getParameter("pId"); //文件所属分类
		User user = getAuthUser();
		Files files = new Files();
		if(user != null){
			
			List<Category> parentList = categoryService.getParentList(pId,user.getId());
			
			CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> t = multiRequest.getFileNames();
			MultipartFile fileDetail = multiRequest.getFile(t.next());
			
			
			if (fileDetail != null) {
				String fileName = fileDetail.getOriginalFilename();
				String type = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()).toLowerCase();
				Long size = fileDetail.getSize();
				
				StringBuilder sb = new StringBuilder("D:/FileSys/upload/" + user.getUsername());

				for(Category category : parentList){
					sb.append("/"+category.getTitle());
				}
				File file = new File(sb.toString());
				if(!file.exists()){
					file.mkdirs();
				}
				File localFile = new File(sb.toString()+"/"+fileName);
				
				//将上传文件写入到指定文件
				try {
					fileDetail.transferTo(localFile);
					
					files.setCategory_id(pId);
					files.setFilename(fileName);
					files.setFilepath(sb.toString()+"/"+fileName);
					files.setFilesize(getFileSize(size));
					files.setFiletype(type);
					files.setUser_id(user.getId());
					files.setUploadDate(new Date());
					files.setUpd_date(new Date());
					files.setInit_date(new Date());
					files.setIcon_path(getIconPath(type));
					service.save(files,getDoubleSize(size), user.getId());
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			out.write("toMycenter?pId="+pId+"&selfId="+pId);
		}else{
			out.write("toLogin");
		}
		
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
	 * 计算文件大小
	 * @param size
	 * @return
	 */
	public float getDoubleSize(Long size){
		float s = (float) (size * 100 / (1024.0 * 1024.0) / 100.0);
		return s;
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
			case "txt": path = "img/text.png";break;
			case "avi": path = "img/avi.png";break;
			case "doc": path = "img/docx_win.png";break;
			case "docx": path = "img/docx_win.png";break;
			case "psd": path = "img/psd.png";break;
			case "mp3": path = "img/mp3.png";break;
			
			default:path = "img/ysj.png";break;
		}
		
		return path;
	}
}
