package com.gudashi.service.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.gudashi.service.TestBase;

public class UserStockDaoTest extends TestBase {
	@Autowired
	private UserStockDao dao;

	@Test
	public void testGetStockList() {
		System.out.println(dao.getStockList("test"));
	}

	@Test @Rollback(false)
	public void testAddStock() {
		dao.addStock("test", String.valueOf(System.currentTimeMillis()));
	}
}
