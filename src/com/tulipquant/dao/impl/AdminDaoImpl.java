package com.tulipquant.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.tulipquant.dao.AdminDao;
import com.tulipquant.mapper.AdminMapper;
import com.tulipquant.pojo.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{
	@Resource(name="adminMapper")
	private AdminMapper adminMapper;
	
	/* 根据用户名查找用户对象 */
    public Admin findAdminByName(String adminName) {
        //调用Mapper类从数据库中得到Admin对象
        return adminMapper.getAdminByName(adminName);
    }
}
