package com.fs.service;

import java.util.List;

import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:52:17
 */
public interface CategoryService {

	//验证该分类是否存在
	public boolean getCategoryByName(String name,int u_id,String pId);
	
	//获取分类（文件夹）列表
	public List<Category> getCategoryList(String p_id,int u_id);
	
	//新增分类
	public void save(Category category);
}
