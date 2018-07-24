package com.tulipquant.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulipquant.service.impl.ChartsServiceImpl;

@Controller
@RequestMapping("/echarts")
public class ChartsController {
	@Resource
	private ChartsServiceImpl chartsServiceImpl;
	
	@RequestMapping(value="/opinionanalysis",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String, Object>> initCharts(){
		return chartsServiceImpl.selectOpinion();
	}
}
