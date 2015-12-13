package com.fs.service;

import java.util.List;

import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:52:17
 */
public interface CategoryService {

	public boolean getCategoryByName(String name,int u_id);
	
	public List<Category> getCategoryList(String p_id,int u_id);
}
