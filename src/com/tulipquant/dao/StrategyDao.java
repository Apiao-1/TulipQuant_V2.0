package com.tulipquant.dao;

import com.tulipquant.pojo.Strategy;

public interface StrategyDao {
	public void addStrategyDao(Strategy strategy);
	
	public void deleteStrategyDao(int sid);
	
	public Strategy getStrategyByIdDao(int sid);
}
