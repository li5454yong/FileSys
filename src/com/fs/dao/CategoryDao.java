package com.fs.dao;

import java.util.List;
import java.util.Map;

import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:38:06
 */
public interface CategoryDao{
	
	public List<Category> findEntity(String hql, Object... objects);
	
	public List<Category> getCategoryList(String p_id,int u_id);
	
	public List<Category> getParentList(String seltId,int userId);
	
	//新增分类
	public void save(Category category);
}
