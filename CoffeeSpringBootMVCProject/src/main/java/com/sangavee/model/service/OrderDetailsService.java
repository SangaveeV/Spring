package com.sangavee.model.service;

import java.sql.SQLException;

import com.sangavee.model.bean.OrderDetails;

public interface OrderDetailsService {

	
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId);
	public int getMaxOrderId();
}
