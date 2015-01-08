package com.gudashi.service.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gudashi.service.entity.User2;

@Repository
public class UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public User2 getById(String id){
		return entityManager.find(User2.class, id);
	}

	public void insert(User2 user){
		entityManager.persist(user);
		entityManager.flush();
	}
}
