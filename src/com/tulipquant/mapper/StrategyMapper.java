package com.tulipquant.mapper;

import com.tulipquant.pojo.Strategy;

public interface StrategyMapper {
	public void addStrategy(Strategy strategy);
	
	public Strategy getStrategyById(int sid);
	
	public void deleteStrategy(int sid);
}
