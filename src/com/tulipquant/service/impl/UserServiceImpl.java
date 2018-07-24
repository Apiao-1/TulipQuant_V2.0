package com.tulipquant.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tulipquant.dao.impl.UserDaoImpl;
import com.tulipquant.mapper.UserMapper;
import com.tulipquant.pojo.User;
import com.tulipquant.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDaoImpl userDao;
	@Resource
	private UserMapper userMapper;
	
	/*登录验证*/
	public User checkLogIn(String username,String password) {
		User user = userDao.findUserByName(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	/*注册*/
	@Override
	public void regist(User user) {
		userDao.addUserDao(user);
	}

	/*删除用户*/
	@Override
	public void delete(int uid) {
		userDao.deleteUserDao(uid);
	}

	@Override
	public Map<String,Object> selectAll(Map<String, Object> param) {
		//bootstrap-table要求服务器返回的json须包含：totlal，rows
        Map<String,Object> result = new HashMap<String,Object>();
        int total=userMapper.selectAll(null).size();
        List<User> rows=userMapper.selectAll(param);
        result.put("total",total);
        result.put("rows",rows);
        return result;
	}
}
