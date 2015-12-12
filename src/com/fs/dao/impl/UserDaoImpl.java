package com.fs.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.fs.dao.UserDao;
import com.fs.entity.User;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:14:47
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Resource
	private SessionFactory sf;
	
	@Override
	public List<User> findEntity(String hql, Object... objects) {
		
		return super.findEntity(hql, objects);
	}

	public void userReg(Object... obj){
		String sql = "insert into t_user(username,password,memory_space,reg_date,init_date,upd_date)"
				+ "values(?,?,?,?,?,?);";
		SQLQuery query = sf.getCurrentSession().createSQLQuery(sql);
		for(int i=0; i<obj.length; i++){
			query.setParameter(i, obj[i]);
		}
		query.executeUpdate();
		
	}
}
