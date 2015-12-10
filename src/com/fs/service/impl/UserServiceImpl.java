package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fs.dao.UserDao;
import com.fs.entity.User;
import com.fs.service.UserService;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:20:14
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

	@Resource
	private UserDao dao;
	
	public List<User> login(Object... objects) {
		String hql = "select id from t_user where username=? and password=?";
		
		return dao.findEntity(hql, objects);
	}

	

}
