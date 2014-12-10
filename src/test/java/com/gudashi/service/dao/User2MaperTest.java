package com.gudashi.service.dao;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gudashi.service.TestBase;
import com.gudashi.service.entity.User2;

public class User2MaperTest extends TestBase {
	@Autowired
	private User2Maper dao;

	@Ignore
	@Test // @Rollback(false)
	public void testInsert() {
		User2 user = new User2();
		user.setId("test");
		user.setName("测试用户");
		dao.insert(user);
	}

	@Test
	public void testGetById() {
		User2 user = dao.getById("test");
		System.out.println(user.getName());
	}
}
