package com.aotian.service.impl;

import com.aotian.dao.UserDao;
import com.aotian.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public boolean querryUserName(String userName) {
		if(userDao.querryUserName(userName) == 0)
			return false;
		else 
			return true;
	}

	public boolean querryUserPassword(String userPassword) {
		if(userDao.querryUserPassword(userPassword) == 0)
			return false;
		else 
			return true;
	}



}
