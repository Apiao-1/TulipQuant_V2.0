package com.tulipquant.service;

import com.tulipquant.pojo.Strategy;

public interface StrategyService {
	public void add(Strategy strategy);
	
	public void delete(int sid);
	
	public Strategy search(int sid);
}
