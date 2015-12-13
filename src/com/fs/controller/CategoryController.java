package com.fs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void addCategory(HttpServletRequest request){
		User user = getAuthUser();
		String title = request.getParameter("title");
		service.getCategoryByName(title, user.getId());
	}
}
