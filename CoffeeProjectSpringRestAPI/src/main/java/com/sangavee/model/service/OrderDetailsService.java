package com.sangavee.model.service;

import com.sangavee.model.bean.OrderDetails;

public interface OrderDetailsService {

	
	public OrderDetails CreateOrder(int orderId,int customerId, int voucherId);
	public int getMaxOrderId();
}
