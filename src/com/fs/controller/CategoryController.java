package com.fs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fs.entity.User;
import com.fs.service.CategoryService;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:31:37
 */
@Controller
public class CategoryController extends BasicController{
	
	@Resource
	private CategoryService service;
	
	@RequestMapping("addCategory")
	public @ResponseBody WebMessage addCategory(HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user = getAuthUser();
		if(user != null){
			String title = request.getParameter("title");
			String 
			boolean flag = service.getCategoryByName(title, user.getId());
			if(flag){
				service.save(category);
			}
			return saveSuccess("false");
		}else{
			//response.getWriter().print("toLogin");
			return saveSuccess("toLogin");
			
		}
		
	}
}
