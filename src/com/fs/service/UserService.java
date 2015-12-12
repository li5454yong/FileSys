package com.fs.service;

import java.util.List;

import com.fs.entity.User;

/**
 * @author lxg
 *
 * 2015年12月10日下午8:18:43
 */
public interface UserService extends BaseService<User> {
	public List<User> login(Object... objects);
	
	public void userReg(Object... obj);
}
