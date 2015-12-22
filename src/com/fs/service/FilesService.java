package com.fs.service;

import java.util.List;

import com.fs.entity.Files;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:46:09
 */
public interface FilesService {
	public List<Files> getFileList(String p_id,int u_id);
	
	public void save(Files file,float size,int user_id);
	
}
