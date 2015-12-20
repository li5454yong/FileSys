package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fs.dao.FilesDao;
import com.fs.entity.Files;
import com.fs.service.FilesService;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:46:59
 */
@Service
public class FilesServiceImpl implements FilesService {

	@Resource
	private FilesDao dao;
	
	//按文件夹获取文件列表
	public List<Files> getFileList(String p_id,int u_id) {
		String sql = "from Files where category_id=? and user_id=?";
		return dao.getFileList(sql,p_id,u_id);
	}

}