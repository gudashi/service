package com.gudashi.service.service;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudashi.service.dao.User2Maper;
import com.gudashi.service.dao.UserMapper;
import com.gudashi.service.entity.User;
import com.gudashi.service.entity.User2;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private User2Maper mapper;

	public User getUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}

	private static Pattern ID_PATTERN = Pattern.compile("[a-zA-Z]+\\w*");
	public User2 register(User2 user){
		if(StringUtils.isBlank(user.getId())){
			throw new IllegalArgumentException("blank id!");
		}
		if(!ID_PATTERN.matcher(user.getId()).matches()){
			throw new IllegalArgumentException("id invalid!");
		}
		if(StringUtils.isBlank(user.getName())){
			throw new IllegalArgumentException("blank name!");
		}
		mapper.insert(user);
		return user;
	}

	public User2 getById(String id) {
		return mapper.getById(id);
	}
}
