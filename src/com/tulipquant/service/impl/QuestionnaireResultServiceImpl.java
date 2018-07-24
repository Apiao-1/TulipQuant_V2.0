package com.tulipquant.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tulipquant.mapper.QuestionnaireResultAddMapper;
import com.tulipquant.pojo.Strategy;
import com.tulipquant.service.QuestionnaireResultService;

@Service
public class QuestionnaireResultServiceImpl implements QuestionnaireResultService {
	@Resource
	private QuestionnaireResultAddMapper questionnaireResultAddMapper;
	
	public void resultAddService(String result) {
		questionnaireResultAddMapper.resultAdd(result);
	}

	@Override
	public String resultGetService(int uid) {
		String result = questionnaireResultAddMapper.resultGet(uid);
		return result;
	}

	@Override
	public Strategy[] getStrategyService(String sTag1, String sTag2) {
		Strategy[] s = questionnaireResultAddMapper.getStrategy(sTag1, sTag2);
		return s;
	}

}
