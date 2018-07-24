package com.tulipquant.service;

import com.tulipquant.pojo.Strategy;

public interface QuestionnaireResultService {
	public void resultAddService(String result);
	
	public String resultGetService(int uid);
	
	public Strategy[] getStrategyService(String sTag1,String sTag2);
}
