package com.tulipquant.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.tulipquant.dao.StrategyDao;
import com.tulipquant.mapper.StrategyMapper;
import com.tulipquant.pojo.Strategy;

@Repository("strategyDao")
public class StrategyDaoImpl implements StrategyDao{
	@Resource(name="strategyMapper")
	private StrategyMapper strategyMapper;
	
	public void addStrategyDao(Strategy strategy) {
		strategyMapper.addStrategy(strategy);
	}
	
	public void deleteStrategyDao(int sid) {
		strategyMapper.deleteStrategy(sid);
	}
	
	public Strategy getStrategyByIdDao(int sid) {
		return strategyMapper.getStrategyById(sid);
	}
}
