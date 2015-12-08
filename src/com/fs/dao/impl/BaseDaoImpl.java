package com.fs.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.fs.dao.BaseDao;

/**
 * 作者：李新广
 * 2015年5月9日下午2:31:12
 * 
 */
@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource
	private SessionFactory sf;


	private Class<T> clazz;
	
	public BaseDaoImpl(){
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();   //得到泛型化超类
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}
	public void saveEntity(T t) {
		sf.getCurrentSession().save(t);
	}

	public void saveOrUpdateEntity(T t) {
		sf.getCurrentSession().saveOrUpdate(t);
	}

	public void updateEntity(T t) {
		sf.getCurrentSession().update(t);
	}

	public void deleteEntity(T t) {
		sf.getCurrentSession().delete(t);
	}

	public void batchEntityByHQL(String hql, Object... objects) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}

	public T loadEntity(Integer id) {
		return (T) sf.getCurrentSession().load(clazz, id);
	}

	public T getEntity(Integer id) {
		return (T) sf.getCurrentSession().get(clazz, id);
	}

	
	public List<T> findEntityEntity(String hql, Object... objects) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}
	
	
	public List<T> queryForPage(String hql,int offset, int length,Object... objects) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<T> list = query.list();
		return list;
	}
	
	
	public int AllRowCount(String hql,Object... objects) {
		Query query = sf.getCurrentSession().createQuery(hql);
		for(int i=0; i<objects.length; i++){
			query.setParameter(i, objects[i]);
		}
		return query.list().size();
	}

}
