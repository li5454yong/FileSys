package com.fs.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fs.service.FilesService;

/**
 * @author lxg
 *
 * 2015年12月23日下午8:53:05
 */
@Controller
public class FileController extends BasicController {
	
	@Resource
	private FilesService filesService;
	
	@RequestMapping("files/paublicShare")
	public void paublicShare(){
		
	}
	
	@RequestMapping("files/privateShare")
	public void privateShare(){
		
	}
}
