package com.gudashi.service.dao;

import org.springframework.stereotype.Repository;

import com.gudashi.service.entity.User2;

@Repository
public interface User2Maper {
	void insert(User2 user);
	User2 getById(String id);
}
