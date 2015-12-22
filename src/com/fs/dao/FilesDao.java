package com.fs.dao;

import java.util.List;

import com.fs.entity.Files;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:40:39
 */
public interface FilesDao {
	
	public List<Files> getFileList(String sql,String p_id,int u_id);
	
	public void save(Files file);
}
