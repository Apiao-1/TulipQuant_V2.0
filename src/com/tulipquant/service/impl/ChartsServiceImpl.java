package com.tulipquant.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tulipquant.mapper.ChartsMapper;
import com.tulipquant.service.ChartsService;

@Service
public class ChartsServiceImpl implements ChartsService{

	@Resource
	private ChartsMapper chartsMapper;
	
	@Override
	public List<Map<String, Object>> selectOpinion() {
		List<Map<String,Object>> data =new ArrayList<>();
        List<Map<String, Object>> listdata=chartsMapper.selectOpinion();
        if(listdata.size()>0){
            for(int i=0;i<listdata.size();i++){
                Map<String,Object> map=new HashMap<>();
                map.put("date", listdata.get(i).get("date"));
                map.put("opinion", listdata.get(i).get("opinion"));
                data.add(map);
            }
        }
        return data;
	}
	
}
