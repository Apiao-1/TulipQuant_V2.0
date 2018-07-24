package com.tulipquant.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tulipquant.dao.impl.AdminDaoImpl;
import com.tulipquant.pojo.Admin;
import com.tulipquant.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDaoImpl adminDao;
	
	/*登录验证*/
	public Admin checkLogIn(String AdminName,String AdminPassword) {
		Admin admin = adminDao.findAdminByName(AdminName);
		if(admin != null && admin.getAdminPassword().equals(AdminPassword)) {
			return admin;
		}
		return null;
	}
}
