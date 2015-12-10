package com.fs.dao.impl;

import java.util.List;

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


	
	@Override
	public List<User> findEntity(String hql, Object... objects) {
		
		return super.findEntity(hql, objects);
	}


}
