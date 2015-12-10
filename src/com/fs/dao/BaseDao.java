package com.fs.dao;

import java.util.List;

/**
 * 作者：李新广
 * 2015年5月9日下午2:27:37
 * 
 */
public interface BaseDao<T> {

	
	public void saveEntity(T t);
	
	public void saveOrUpdateEntity(T t);
	
	public void updateEntity(T t);
	
	public void deleteEntity(T t);
	
	public void batchEntityByHQL(String hql,Object...objects);
	
	
	
	public T loadEntity(Integer id);
	
	public T getEntity(Integer id);
	
	public List<T> findEntity(String hql,Object...objects);
	
	public List<T> queryForPage(String hql,int offset,int length,Object... objects);
	
	public int AllRowCount(String hql,Object... objects);
}
