package com.fs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;

/**
 * @author lxg
 *
 *         2015年12月13日下午1:31:37
 */
@Controller
public class CategoryController extends BasicController {

	@Resource
	private CategoryService service;
	
	@Resource
	private FilesService filesService;

	/**
	 * 点击文件夹时获取他的子类
	 * @param selfId
	 * @return
	 */
	@RequestMapping("getNextContent")
	public @ResponseBody WebMessage getContent(String selfId){
		User user = getAuthUser();
		if (user != null) {
			List<Category> categoryList = service.getCategoryList(selfId,user.getId());
			List<Files> fileList = filesService.getFileList(selfId,user.getId());
			
			StringBuilder sb = new StringBuilder(JSON.toJSONString(categoryList));
			sb.append("@LXG");
			sb.append(fileList);
			
			return saveSuccess(sb.toString());
		} else {
			return saveSuccess("toLogin");
		}
	}
	
	/**
	 * 添加分类
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("addCategory")
	public @ResponseBody WebMessage addCategory(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		User user = getAuthUser();
		if (user != null) {
			Category category = new Category();
			String title = request.getParameter("title");
			String pId = request.getParameter("pId");
			String length = request.getParameter("length");
			StringBuilder sb = new StringBuilder();
			if (!"0".equals(pId)) {
				sb.append(pId);
				sb.append(10 + Integer.parseInt(length));
			} else {
				sb.append(10 + Integer.parseInt(length));
			}
			category.setP_id(pId);
			category.setSelf_id(sb.toString());
			category.setTitle(title);
			category.setInit_date(new Date());
			category.setUpd_date(new Date());
			category.setU_id(user.getId());
			boolean flag = service.getCategoryByName(title, user.getId(), pId);
			if (flag) { // 判断分类是否存在
				service.save(category);
				return saveSuccess("toMycenter");
			} else {
				return saveSuccess("false");
			}
		} else {
			return saveSuccess("toLogin");
		}
	}
}
