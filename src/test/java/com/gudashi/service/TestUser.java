package com.gudashi.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.gudashi.service.entity.User;
import com.gudashi.service.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:conf-spring/spring-context.xml","classpath:conf-spring/spring-context-mybatis.xml"})
@ActiveProfiles("development") 
@Ignore
public class TestUser {
	
	private final static Logger logger = LoggerFactory.getLogger(TestUser.class);

	@Autowired
	private UserService userService;

	@Test
	public void test() {
		User u = userService.getUserById(1L);
		logger.debug("根据ID获取用户："+JSON.toJSONString(u));
	}
}
