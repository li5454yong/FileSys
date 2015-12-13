package com.fs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;
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
	
	@Resource
	private FilesService filesService;
	
	@Resource
	private CategoryService categoryService;
	//登录
	@RequestMapping("login")
	public void Login(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		String password = MD5.MD5Encode(request.getParameter("password"));
		List<User> l = servise.login(username);
		if(l.size() == 1){
			User u = l.get(0);
			if(u.getPassword().equals(password)){
				request.getSession().setAttribute("USER",u);
				response.getWriter().print("0");//登录成功
			}else{
				response.getWriter().print("2");//密码错误
			}
		}else{
			response.getWriter().print("1");//用户名不存在
		}
	}
	
	//跳转到注册页面
	@RequestMapping("toReg")
	public String toReg(){
		return "mycenter/reg";
	}
	
	//注册
	@RequestMapping("reg")
	public String Reg(HttpServletRequest request){
		String username = request.getParameter("yourname");
		String password = request.getParameter("yourpass");
		String email = request.getParameter("youremail");
		servise.userReg(username,MD5.MD5Encode(password),2048,new Date(),new Date(),new Date());
		
		return redirect("/toLogin");
	}
	
	//跳转到个人中心
	@RequestMapping("toMycenter")
	public String toMycenter(Model map){
		User user = getAuthUser();
		if(user != null){
			
			List<Category> categoryList = categoryService.getCategoryList("0",user.getId());
			List<Files> fileList = filesService.getFileList("0",user.getId());
			map.addAttribute("fileList", fileList);
			map.addAttribute("categoryList", categoryList);
		}else{
			return redirect("toLogin");
		}
		
		
		return "mycenter/index";
	}
	
	//跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}
	
}
