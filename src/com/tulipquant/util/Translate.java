package com.tulipquant.util;
import org.apache.commons.lang.StringUtils;

import com.tulipquant.pojo.Strategy;
public class Translate {
	public static String toJson(String s) {
		s=s+"中百集团,sz000759,塑料瓶";
		System.out.println(s);
		String[] split = s.split("\n");
		String[] re = new String[7];
		String[] num = new String[5];
		for(int i=0;i<5;i++) {
			String a = split[i].substring(12);
			re[i] = StringUtils.substringBefore(a, "(");
			String b = split[i].split("=")[1];
			num[i] = StringUtils.substringBefore(b, ")");
		}
		String[] company = split[5].split(",");
		String result = "{" + 
				"  \"photoResult\":[" + 
				"    {\"result\":\""+re[0]+"\",\"ratio\":\""+num[0]+"\"}," + 
				"    {\"result\":\""+re[1]+"\",\"ratio\":\""+num[1]+"\"}," + 
				"    {\"result\":\""+re[2]+"\",\"ratio\":\""+num[2]+"\"}," + 
				"    {\"result\":\""+re[3]+"\",\"ratio\":\""+num[3]+"\"}," + 
				"    {\"result\":\""+re[4]+"\",\"ratio\":\""+num[4]+"\"}" + 
				"  ]," + 
				"  \"company\":\""+company[0]+"\"," + 
				"  \"code\":\""+company[1]+"\"," + 
				"  \"major\":\""+company[2]+"\"" + 
				"}";
		return result;
	}
	
	public static String answerTrans(int[] a,int b) {
		String result = "";
		for(int i=0,j=0; i<b||j<a.length-1; i++) {
			if(j>=a.length) {
				result += "0,";
			}
			else {
				if((i+1)==a[j]) {
					result += "1,";
					j++;
				}
				else {
					result += "0,";
				}
			}
		}
		result = result.substring(0, b*2-1);
		return result;
	}
	
	public static String StrategyToJson(Strategy[] st) {
		String result="{" + 
				"\"success\":\"true\"," + 
				"\"strategy\":[" + 
				"	{" + 
				"		\"title\":\""+st[0].sName+"\"," + 
				"		\"auther\":\""+st[0].auther+"\"," + 
				"		\"portrait\":\""+st[0].portrait+"\"," + 
				"		\"classify\":{" + 
				"			\"classfyName1\":\""+st[0].sTag1+"\"," + 
				"			\"classfyName2\":\""+st[0].sTag2+"\"" + 
				"		}," + 
				"		\"img\":\""+st[0].sImg+"\"," + 
				"		\"profitYear\":\""+st[0].sBenefitY+"%\"," + 
				"		\"withdraw\":\""+st[0].sWithdraw+"%\"," + 
				"		\"money\":\""+st[0].sMoneyBegin+"\"," + 
				"		\"limit\":\""+st[0].sSubscribLimit+"\"," + 
				"		\"price\":\""+st[0].sPrice+"元/月\"" + 
				"	}," + 
				"	{" + 
				"		\"title\":\""+st[1].sName+"\"," + 
				"		\"auther\":\""+st[1].auther+"\"," + 
				"		\"portrait\":\""+st[1].portrait+"\"," + 
				"		\"classify\":{" + 
				"			\"classfyName1\":\""+st[1].sTag1+"\"," + 
				"			\"classfyName2\":\""+st[1].sTag2+"\"" + 
				"		}," + 
				"		\"img\":\""+st[1].sImg+"\"," + 
				"		\"profitYear\":\""+st[1].sBenefitY+"%\"," + 
				"		\"withdraw\":\""+st[1].sWithdraw+"%\"," + 
				"		\"money\":\""+st[1].sMoneyBegin+"\"," + 
				"		\"limit\":\""+st[1].sSubscribLimit+"\"," + 
				"		\"price\":\""+st[1].sPrice+"元/月\"" + 
				"	}" +
				"]" + 
			"}";
		return result;
	}
}
