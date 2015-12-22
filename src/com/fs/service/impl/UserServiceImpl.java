package com.fs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fs.dao.BaseDao;
import com.fs.dao.UserDao;
import com.fs.entity.User;
import com.fs.service.UserService;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:20:14
 */
@Service
public class UserServiceImpl implements
		UserService {

	@Resource
	private UserDao dao;
	
	public List<User> login(Object... objects) {
		String hql = "from User where username=?";
		try{
			return dao.findEntity(hql, objects);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public void userReg(Object... obj) {
		dao.userReg(obj);
	}

	@Override
	public void updateSpace(float size, int id) {
		dao.updateSpace(size, id);
	}

	

}
