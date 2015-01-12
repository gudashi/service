package com.gudashi.service.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity @Table(name="user_stock")
public class UserStock {
	@EmbeddedId
	private UserStockPK id;

	public UserStock() {
	}
	
	public UserStock(String userId, String stockId) {
		id = new UserStockPK(userId, stockId);
	}

	public UserStockPK getId() {
		return id;
	}

	public void setId(UserStockPK id) {
		this.id = id;
	}

	@Transient
	public String getUserId() {
		return id != null ? id.getUserId() : null;
	}

	@Transient
	public String getStockId() {
		return id != null ? id.getStockId() : null;
	}
}
