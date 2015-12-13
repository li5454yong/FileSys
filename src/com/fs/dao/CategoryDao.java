package com.fs.dao;

import java.util.List;

import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:38:06
 */
public interface CategoryDao{
	
	public List<Category> findEntity(String hql, Object... objects);
}
