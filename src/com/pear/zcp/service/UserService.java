package com.pear.zcp.service;

import java.util.List;

import com.pear.zcp.entity.User;

public interface UserService {

	public void addUser(User user);
	public List<User> getAllUser();
	
}
