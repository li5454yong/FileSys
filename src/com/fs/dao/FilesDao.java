package com.fs.dao;

import java.util.List;

import com.fs.entity.Category;
import com.fs.entity.Files;
import com.fs.entity.Filing;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:40:39
 */
public interface FilesDao {
	
	public List<Files> getFileList(String sql,String p_id,int u_id);
	
	public void save(Files file);
	
	//创建公开分享
	public void paublicShare(int id,String shareUrl);
	
	//创建私密分享
	public void privateShare(int id,String shareUrl,String pw);
	
	//获取文件存档
	public List<Filing> getFiling(int userId);
	
	public List<Files> getPaublicShare(String publicSharePath);
	
	//根据id获取文件
	public Files get(int id);
	
	//删除一个文件
	public void delete(Files file);
	
	//删除一个文件夹下的文件
	public void delete(Category category);
}
