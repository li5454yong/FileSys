package com.fs.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.entity.User;
import com.fs.service.UserService;
import com.fs.util.MD5;

/**
 * @author lxg
 *
 * 2015年12月10日下午7:57:16
 */

@Controller
public class UserController extends BasicController{
	
	@Resource
	private UserService servise;
	
	@RequestMapping("login")
	public void Login(HttpServletRequest request){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		List<User> l = servise.login(username,password);
		System.out.println(l.toString());
	}
	
	//跳转到注册页面
	@RequestMapping("toReg")
	public String toReg(){
		return "mycenter/reg";
	}
	
	@RequestMapping("reg")
	public String Reg(HttpServletRequest request){
		String username = request.getParameter("yourname");
		String password = request.getParameter("yourpass");
		String email = request.getParameter("youremail");
		servise.userReg(username,MD5.MD5Encode(password),2048,new Date(),new Date(),new Date());
		
		return redirect("/toLogin");
	}
	
	@RequestMapping("toLogin")
	public String toLogin(){
		
		return "login";
	}
}
