package com.tulipquant.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tulipquant.pojo.Admin;
import com.tulipquant.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private AdminServiceImpl adminServiceImpl;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(Admin admin,Model model) throws Exception {
		admin = adminServiceImpl.checkLogIn(admin.getAdminName(), admin.getAdminPassword());
		if(admin != null) {
			model.addAttribute(admin);
			return "welcome";
		}
		return "failed";
	}
	
	
}