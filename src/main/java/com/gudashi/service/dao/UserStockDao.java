package com.gudashi.service.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.gudashi.service.entity.UserStock;

@Repository
public class UserStockDao {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<String> getStockList(String userId){
		return entityManager.createQuery("select id.stockId from " + UserStock.class.getSimpleName() + " where id.userId = ?")
			.setParameter(1, userId)
			.getResultList();
	}

	public void addStock(String userId, String stockId){
		entityManager.merge(new UserStock(userId, stockId));
		entityManager.flush();
	}
}
