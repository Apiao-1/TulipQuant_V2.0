package com.tulipquant.dao;

import com.tulipquant.pojo.Admin;

public interface AdminDao {
	public Admin findAdminByName(String AdminName);
}
