package com.gudashi.service.dao;

import org.springframework.stereotype.Repository;

import com.gudashi.service.entity.User;

@Repository
public interface UserMapper {
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
}