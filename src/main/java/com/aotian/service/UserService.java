package com.aotian.service;

public interface UserService {
	//查询用户名是否存在
	public boolean querryUserName(String userName); 
	//查询用户名是否正确
	public boolean querryUserPassword(String userPassword); 
}
