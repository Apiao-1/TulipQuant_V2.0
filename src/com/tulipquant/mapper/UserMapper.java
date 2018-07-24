package com.tulipquant.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;


import com.tulipquant.pojo.User;

@Repository
public interface UserMapper {
	public User getUserByName(String username);
	
	public void addUser(User user);
	
	public int deleteUser(int uid);
	
	public User searchUser(User user);
	
	public List<User> selectAll(Map<String, Object> param);
}
