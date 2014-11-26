package com.gudashi.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudashi.service.dao.UserMapper;
import com.gudashi.service.entity.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
