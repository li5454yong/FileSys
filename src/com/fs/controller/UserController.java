package com.fs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.entity.User;
import com.fs.service.UserService;

/**
 * @author lxg
 *
 * 2015年12月10日下午7:57:16
 */

@Controller
public class UserController {
	
	@Resource
	private UserService servise;
	
	@RequestMapping("login")
	public void Login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> l = servise.login(username,password);
		System.out.println(l.toString());
	}
}
