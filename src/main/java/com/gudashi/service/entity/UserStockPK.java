package com.gudashi.service.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserStockPK implements Serializable {
	private static final long serialVersionUID = -6353664682579298588L;

	@Column(name="user_id")
	private String userId;
	@Column(name="stock_id")
	private String stockId;

	public UserStockPK() {
	}

	public UserStockPK(String userId, String stockId) {
		this.userId = userId;
		this.stockId = stockId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
