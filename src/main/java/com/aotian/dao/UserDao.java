package com.aotian.dao;

public interface UserDao {
	//查询用户名是否存在
	public int querryUserName(String userName); 
	//查询用户名是否正确
	public int querryUserPassword(String userPassword); 

}
