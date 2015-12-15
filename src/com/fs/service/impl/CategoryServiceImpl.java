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
	public boolean getCategoryByName(String name,int u_id,String pId){
		String hql = "from Category where title=? and u_id=? and p_id=?";
		List<Category> list = dao.findEntity(hql, name,u_id,pId);
		
		if(list.size() == 0){
			return true; //表示该分类不存在
		}else{
			return false;
		}
	}
	
	public List<Category> getCategoryList(String p_id,int u_id){
		return dao.getCategoryList(p_id,u_id);
	}

	@Override
	public void save(Category category) {
		dao.save(category);
		
	}
}
