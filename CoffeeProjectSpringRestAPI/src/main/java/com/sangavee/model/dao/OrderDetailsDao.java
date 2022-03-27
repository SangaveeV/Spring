package com.sangavee.model.dao;

import com.sangavee.model.bean.OrderDetails;

public interface OrderDetailsDao {

	public OrderDetails CreateOrder(int orderId,int customerId, int voucherId);
	public int getMaxOrderId();
			
}
