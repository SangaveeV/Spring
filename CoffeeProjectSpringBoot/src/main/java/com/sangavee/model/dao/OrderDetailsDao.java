package com.sangavee.model.dao;

import java.sql.SQLException;

import com.sangavee.model.bean.OrderDetails;

public interface OrderDetailsDao {

	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId);
	public int getMaxOrderId();
			
}
