package com.fs.dao.impl;

import java.util.List;




import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fs.dao.CategoryDao;
import com.fs.entity.Category;

/**
 * @author lxg
 *
 * 2015年12月13日下午1:38:31
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {
	@Resource
	private SessionFactory sf;
	
	public List<Category> findEntity(String hql, Object... objects){
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}
}