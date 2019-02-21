package com.aotian.dao.impl;

import org.hibernate.Session;

import com.aotian.dao.BaseDAO;
import com.aotian.dao.UserDao;

public class UserDaoImpl extends BaseDAO implements UserDao {

	public int querryUserName(String userName) {
		Session session = getSession();
		String sql = "select count(*) from User where userName = " +" '" +userName+ "' " ;
		org.hibernate.query.Query query = session.createQuery(sql);
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}

	public int querryUserPassword(String userPassword) {
		Session session = getSession();
		String sql = "select count(*) from User where userPassword = " +" '" +userPassword+ "' ";
		org.hibernate.query.Query query = session.createQuery(sql);
		int count = ((Long) query.iterate().next()).intValue();
		session.close();
		return count;
	}

}
