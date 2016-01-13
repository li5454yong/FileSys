package com.fs.dao;

import java.util.List;
import java.util.Map;

import com.fs.entity.Category;
import com.fs.entity.Files;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:38:06
 */
public interface CategoryDao{
	
	public List<Category> findEntity(String hql, Object... objects);
	
	public List<Category> getCategoryList(String p_id,int u_id);
	
	public List<Category> getParentList(String seltId,int userId);
	
	//公开分享
	public void paublicShare(int id,String shareUrl);
	
	//新增分类
	public void save(Category category);
	
	//私密  分享
	public void privateShare(int id, String shareUrl, String pw);
	
	//根据公开分享链接获取分享的文件夹
	public List<Category> getPaublicShare(String publicSharePath);
	
	//根据id获取文件
	public Category get(int id);
}
