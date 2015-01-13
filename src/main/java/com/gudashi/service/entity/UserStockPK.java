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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stockId == null) ? 0 : stockId.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserStockPK other = (UserStockPK) obj;
        if (stockId == null) {
            if (other.stockId != null)
                return false;
        } else if (!stockId.equals(other.stockId))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }
}
