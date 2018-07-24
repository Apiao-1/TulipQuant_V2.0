package com.tulipquant.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulipquant.pojo.Strategy;
import com.tulipquant.service.impl.StrategyServiceImpl;

@Controller
@RequestMapping("/strategy")
public class StrategyController {
	@Resource
	private StrategyServiceImpl strategyServiceImpl;
	
	@RequestMapping(value="/addStrategy",method=RequestMethod.POST)
	@ResponseBody
	public String addStrategy(Strategy strategy) throws Exception {
		strategyServiceImpl.add(strategy);
		return "{\"result\":\"true\"}";
	}
	
	@RequestMapping(value="/deleteStrategy",method=RequestMethod.POST)
	@ResponseBody
	public String deleteStrategy(@RequestParam("sid") int sid) throws Exception {
		strategyServiceImpl.delete(sid);
		return "{\"result\":\"true\"}";
	}
	
	@RequestMapping(value="/searchStrategy",method=RequestMethod.POST)
	@ResponseBody
	public String searchStrategy(int sid) throws Exception {
		strategyServiceImpl.search(sid);
		return "{\"result\":\"true\"}";
	}

}
