package com.fs.dao;

import java.util.List;

import com.fs.entity.User;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:07:14
 */

public interface UserDao {
	public void userReg(Object... obj);
	public List<User> findEntity(String hql, Object... objects);
}
