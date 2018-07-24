package com.tulipquant.mapper;

import com.tulipquant.pojo.Strategy;

public interface QuestionnaireResultAddMapper {
	//保存板块结果进数据库
	public void resultAdd(String result);
	
	//拉取对应用户的推荐板块
	public String resultGet(int uid);
	
	//拉取具体策略结果，参数为cut过的板块名称
	public Strategy[] getStrategy(String sTag1,String sTag2);
}
