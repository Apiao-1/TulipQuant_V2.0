package com.tulipquant.dao;


import com.tulipquant.pojo.User;

public interface UserDao {
	
	public void addUserDao(User user);
	
	public User findUserByName(String username);
	
	public int deleteUserDao(int uid);
	
	public User searchUserDao(User user);
	
}
