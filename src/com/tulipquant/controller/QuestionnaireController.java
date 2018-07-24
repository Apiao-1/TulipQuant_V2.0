package com.tulipquant.controller;

import java.io.IOException;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tulipquant.pojo.Strategy;
import com.tulipquant.python.recommendation;
import com.tulipquant.service.impl.QuestionnaireResultServiceImpl;
import com.tulipquant.util.Translate;
import com.tulipquant.util.operateFile;

@Controller
@RequestMapping("/questionnaire")
public class QuestionnaireController {
	@Resource
	private QuestionnaireResultServiceImpl questionnaireResultServiceImpl;

	@RequestMapping(value="/question",method=RequestMethod.POST)
	@ResponseBody
	public String questionnaire(
			@RequestParam("q1") int q1,
			@RequestParam("q2") int q2,
			@RequestParam("q3") int[] q3,
			@RequestParam("q4") int q4,
			@RequestParam("q5") int q5,
			@RequestParam("q6") int[] q6,
			@RequestParam("q7") int q7,
			@RequestParam("q8") int q8,
			@RequestParam("q9") int[] q9
			) throws IOException, InterruptedException
	{
		//答案整理
		String Q3 = Translate.answerTrans(q3, 4);
		String Q6 = Translate.answerTrans(q6, 4);
		String Q9 = Translate.answerTrans(q9, 7);
		String answer = "year,money,Astock,Hstock,Ustock,Futures,marketValue,frequency,valueInvest,compound,wheeled,theme,risk,returns\r\n" + 
				q1 + "," + q2 + "," + Q3 + "," + q4 + "," + q5 + "," + Q6 + "," + q7 + "," + q8 + "," + Q9;
		operateFile.write("/home/recommendation/feature.txt", answer);
		
		//调用推荐程序
		String result = recommendation.recommend();
		
		//将结果写入数据库
		//questionnaireResultServiceImpl.resultAddService(result);
		
		//具体策略json拉取
//		System.out.println(result);
		String[] tag = new String[2];
		try {
			tag = result.split("\n");
			System.out.println(tag[0]+","+tag[1]);
		}
		catch (Exception e) {
			result="动量反转"+"\n"+"大市值";
			tag = result.split("\n");
			System.out.println(tag[0]+","+tag[1]);
		}
		Strategy[] st = questionnaireResultServiceImpl.getStrategyService(tag[0], tag[1]);
		String strategy = Translate.StrategyToJson(st);
		result = "{" + 
				"\"result\":[\""+tag[0]+"\",\""+tag[1]+"\"]," + 
				"\"data\":"+ strategy +
				"}";
		System.out.println(result);
		
		return result;
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	@ResponseBody
	public String result(@RequestParam("uid") int uid) {
		String result = questionnaireResultServiceImpl.resultGetService(uid);
		return result;
	}
}
