package com.tulipquant.service;

import com.tulipquant.pojo.Admin;

public interface AdminService {
	public Admin checkLogIn(String AdminName,String AdminPassword);
}
