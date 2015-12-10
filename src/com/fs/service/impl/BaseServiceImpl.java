package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.fs.dao.BaseDao;
import com.fs.service.BaseService;


/**
 * 作者：李新广
 * 2015年5月9日下午2:36:29
 * 
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {


	private BaseDao<T> dao;
	
	@Resource
	public void setDao(BaseDao<T> dao) {
		this.dao = dao;
	}

	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		dao.batchEntityByHQL(hql, objects);
	}

	public T loadEntity(Integer id) {
		return dao.loadEntity(id);
	}

	public T getEntity(Integer id) {
		return dao.getEntity(id);
	}

	public List<T> findEntityByHQL(String hql, Object... objects) {
		return dao.findEntity(hql, objects);
	}

	@Override
	public List<T> queryForPage(String hql, int offset, int length,Object... objects) {
		return dao.queryForPage(hql, offset, length,objects);
	}

	@Override
	public int AllRowCount(String hql,Object... objects) {
		return dao.AllRowCount(hql,objects);
	}

}
