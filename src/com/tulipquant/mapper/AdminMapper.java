package com.tulipquant.mapper;

import org.springframework.stereotype.Repository;

import com.tulipquant.pojo.Admin;

@Repository
public interface AdminMapper {
	public Admin getAdminByName(String AdminName);
}
