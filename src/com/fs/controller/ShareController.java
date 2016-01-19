package com.fs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Filing;
import com.fs.entity.User;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;

/**
 * @author lxg
 *
 *         2016年1月19日下午7:59:34
 */
@Controller
@RequestMapping("share")
public class ShareController extends BasicController{

	@Resource
	private FilesService filesService;
	@Resource
	private CategoryService categoryService;

	@RequestMapping("getnext")
	public @ResponseBody WebMessage getNext(String pId, String selfId,int user_id,String url) {

		// 加载的文件夹列表
		List<Category> categoryList = categoryService.getCategoryList(pId,
				user_id);
		// 加载的文件列表
		List<Files> fileList = filesService.getFileList(pId, user_id);
		// 加载的浏览导航
		/*List<Category> parentList = categoryService.getParentList(selfId,
				user_id);*/

		/*List<Filing> filingList = filesService.getFiling(user_id);

		List<Category> tagCloud = categoryService.getCategoryList(null,
				user_id);*/
		String categorys = JSON.toJSONString(categoryList);
		String files = JSON.toJSONString(fileList);
		
		return saveSuccess(categorys + "@LXG" + files);
		//return "mycenter/index";
	}
}
