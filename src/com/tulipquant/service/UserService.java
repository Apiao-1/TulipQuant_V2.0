package com.tulipquant.service;

import java.util.Map;

import com.tulipquant.pojo.User;

public interface UserService {
	public User checkLogIn(String username,String password);
	
	public void regist(User user);
	
	public void delete(int uid);
	
	public Map<String,Object> selectAll(Map<String, Object> param);
}
