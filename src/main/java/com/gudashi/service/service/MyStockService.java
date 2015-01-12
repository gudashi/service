package com.gudashi.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gudashi.service.dao.UserStockDao;

@Service
public class MyStockService {
	@Autowired
	private UserStockDao dao;

	public List<String> getStockList(String userId) {
		return dao.getStockList(userId);
	}

	@Transactional
	public void addStock(String userId, String... stockIdArray) {
		for(String stockId : stockIdArray){
			dao.addStock(userId, stockId);
		}
	}
}
