package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fs.dao.BaseDao;
import com.fs.dao.CategoryDao;
import com.fs.entity.Category;
import com.fs.service.CategoryService;
/**
 * @author lxg
 *
 * 2015年12月13日下午1:53:19
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Resource
	private CategoryDao dao;

	@Override
	public boolean getCategoryByName(String name,int u_id){
		String hql = "from Category where title=? and u_id=?";
		List<Category> list = dao.findEntity(hql, name,u_id);
		
		if(list.size() == 0){
			return false;
		}else{
			return true;
		}
	}
	
	public List<Category> getCategoryList(String p_id,int u_id){
		return dao.getCategoryList(p_id,u_id);
	}
}
