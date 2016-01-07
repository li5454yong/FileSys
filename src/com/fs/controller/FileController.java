package com.fs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Share;
import com.fs.service.CategoryService;
import com.fs.service.FilesService;
import com.fs.util.UUIDUtil;

/**
 * @author lxg
 *
 * 2015年12月23日下午8:53:05
 */
@Controller
@RequestMapping("files")
public class FileController extends BasicController {
	
	@Resource
	private FilesService filesService;
	@Resource
	private CategoryService categoryService;
	
	/**
	 * 创建公开分享链接
	 * @param share
	 * @return
	 */
	@RequestMapping("paublicShare")
	public @ResponseBody WebMessage paublicShare(String share){
		String shareUrl = UUIDUtil.get8str();
		List<Share> list = JSONArray.parseArray(share, Share.class);
		for(Share s : list){
			if("category".equals(s.getType())){
				
				categoryService.paublicShare(s.getId(), shareUrl);
				
			}else if("file".equals(s.getType())){
				
				filesService.paublicShare(s.getId(), shareUrl);
				
			}
		}
		return saveSuccess("getPaublicShare/"+shareUrl);
	}
	
	/**
	 * 创建私密分享链接
	 * @param share
	 * @return
	 */
	@RequestMapping("privateShare")
	public @ResponseBody WebMessage privateShare(String share){
		String shareUrl = UUIDUtil.get8str();
		String pw = UUIDUtil.get5str();
		List<Share> list = JSONArray.parseArray(share, Share.class);
		for(Share s : list){
			if("category".equals(s.getType())){
				
				categoryService.privateShare(s.getId(), shareUrl, pw);
				
			}else if("file".equals(s.getType())){
				
				filesService.privateShare(s.getId(), shareUrl, pw);
				
			}
		}
		
		return saveSuccess(shareUrl+"@LXG"+pw);
	}
	
	/**
	 * 获取公开分享的文件和文件夹
	 * @param publicSharePath
	 * @param model
	 * @return
	 */
	@RequestMapping(value="getPaublicShare/{publicSharePath}")
	public String getPaublicShare(@PathVariable String publicSharePath,Model model){
		
		List<Files> fileList = filesService.getPaublicShare(publicSharePath);
		List<Category> categoryList = categoryService.getPaublicShare(publicSharePath);
		
		model.addAttribute("fileList", fileList);
		model.addAttribute("categoryList", categoryList);
		if(fileList.size()==0 && categoryList.size()==0){
			return "file/";
		}else if(fileList.size()==1 && categoryList.size() == 0){
			model.addAttribute("file", fileList.get(0));
			return "file/downLoad1";
		}else{
			return "file/downLoad2";
		}
		
	}
}
