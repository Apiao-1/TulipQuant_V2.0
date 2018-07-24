package com.tulipquant.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tulipquant.pojo.User;
import com.tulipquant.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserServiceImpl userServiceImpl;
	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(User user,Model model) throws Exception {
//		user = userServiceImpl.checkLogIn(user.getUsername(), user.getPassword());
//		if(user != null) {
//			model.addAttribute(user);
//			return "welcome";
//		}
//		return "failed";
//	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String loginajax(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) throws Exception {
		System.out.println(username + "\n" + password);
		User user = userServiceImpl.checkLogIn(username, password);
		if(user != null) {
			session.setAttribute("username",username);
			return "{\"result\":\"true\"}";
		}
		return "{\"result\":\"false\"}";
	}

	/*@RequestMapping(value="/signin",method=RequestMethod.POST)
	public String signin(User user,Model model) throws Exception {
		user.setUid(2);
		userServiceImpl.regist(user);
		model.addAttribute(user);
		return "welcome";
	}*/
	
	@RequestMapping(value="/signin",method=RequestMethod.POST)
	@ResponseBody
	public String signin(User user) throws Exception {
		user.setUid(2);
		userServiceImpl.regist(user);
		return "welcome";
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public String deleteUser(int uid) throws Exception {
		userServiceImpl.delete(uid);
		return "{\"result\":\"true\"}";
	}

	@RequestMapping(value="/table",method=RequestMethod.POST)
	@ResponseBody
	public  Map<String,Object> selectAll(int pageSize,int pageNumber,String username,Integer uid){
		Map<String, Object> param=new HashMap<String, Object>();
		int a=(pageNumber-1)*pageSize;
		int b=pageSize;
		param.put("a", a);
		param.put("b", b);
		param.put("username", username);
		param.put("uid", uid);
		return userServiceImpl.selectAll(param);
	}
}