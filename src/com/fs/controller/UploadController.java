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
import com.fs.util.FileUtil;

@Controller
public class UploadController extends BasicController {

	@Resource
	private FilesService service;
	
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 文件上传
	 * @param request
	 * @param out
	 */
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
					files.setFilesize(FileUtil.getFileSize(size));
					files.setFiletype(type);
					files.setUser_id(user.getId());
					files.setUploadDate(new Date());
					files.setUpd_date(new Date());
					files.setInit_date(new Date());
					files.setIcon_path(FileUtil.getIconPath(type));
					service.save(files,FileUtil.getDoubleSize(size), user.getId());
					
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
	
}
