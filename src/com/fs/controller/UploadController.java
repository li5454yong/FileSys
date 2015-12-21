package com.fs.controller;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {

	@RequestMapping("upload")
	public void upload(HttpServletRequest request, HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		String a = request.getParameter("key");
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
		Iterator<String> t = multiRequest.getFileNames();
		MultipartFile fileDetail = multiRequest.getFile(t.next());
		if (fileDetail != null) {
			String fileName = fileDetail.getOriginalFilename();
			String type = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			Long size = fileDetail.getSize();
			String path = "D:/" + fileName;
			File localFile = new File(path);
			//将上传文件写入到指定文件
			try {
				fileDetail.transferTo(localFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//非常重要、有了这个想做什么处理都可以
			//fileDetail.getInputStream();
		}
		System.out.println(t.next());
	}
}
