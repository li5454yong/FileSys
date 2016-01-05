package com.fs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
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
		return saveSuccess(shareUrl);
	}
	
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
}
