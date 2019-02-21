package com.aotian.action;

import com.aotian.domain.User;
import com.aotian.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private User user = new User();

	public User getModel() {
		return user;
	}

	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		System.out.println(user.getUserName());
		System.out.println(user.getUserPassword());
		
		if(userService.querryUserName(user.getUserName()) && 
				userService.querryUserPassword(user.getUserPassword()))
			return SUCCESS;
		else
			return ERROR;		
	}


	
	
}
