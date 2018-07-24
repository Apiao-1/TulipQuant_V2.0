package com.tulipquant.dao.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.tulipquant.dao.UserDao;
import com.tulipquant.mapper.UserMapper;
import com.tulipquant.pojo.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	/* 根据用户名查找用户对象 */
    public User findUserByName(String username) {
        //调用Mapper类从数据库中得到User对象
        return userMapper.getUserByName(username);
    }

	@Override
	public void addUserDao(User user) {
		userMapper.addUser(user);
	}

	@Override
	public int deleteUserDao(int uid) {
		userMapper.deleteUser(uid);
		return 0;
	}

	@Override
	public User searchUserDao(User user) {

		return null;
	}

	
}
