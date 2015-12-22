package com.fs.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fs.dao.FilesDao;
import com.fs.entity.Files;

/**
 * @author lxg
 *
 * 2015年12月13日下午5:41:09
 */
@Repository("filesDao")
public class FilesDaoImpl implements FilesDao {

	@Resource
	private SessionFactory sf;
	
	@Override
	public List<Files> getFileList(String sql,String p_id,int u_id) {
		try {
			
			Query query = sf.getCurrentSession().createQuery(sql);
			query.setString(0, p_id);
			query.setInteger(1, u_id);
			return query.list();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void save(Files file) {

		sf.getCurrentSession().save(file);
		
	}

}
