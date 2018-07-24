package com.tulipquant.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.tulipquant.dao.StrategyDao;
import com.tulipquant.pojo.Strategy;
import com.tulipquant.service.StrategyService;

@Service("strategyService")
public class StrategyServiceImpl implements StrategyService{
	@Resource
	private StrategyDao strategyDao;
	
	public void add(Strategy strategy) {
		strategyDao.addStrategyDao(strategy);
	}
	
	public void delete(int sid) {
		strategyDao.deleteStrategyDao(sid);
	}
	
	public Strategy search(int sid) {
		return strategyDao.getStrategyByIdDao(sid);
	}
}
