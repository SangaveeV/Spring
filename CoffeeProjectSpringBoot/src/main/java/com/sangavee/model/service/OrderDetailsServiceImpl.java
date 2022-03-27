package com.sangavee.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.dao.OrderDetailsDao;

@Service("OrderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	public void setOrderDetailsDao(OrderDetailsDao orderDetailsDao) {
		this.orderDetailsDao = orderDetailsDao;
	}
	@Override
	public int CreateOrder(int orderId,int customerId, String orderDate, int voucherId) {		
		orderDetailsDao.CreateOrder(orderId,customerId, orderDate, voucherId);	
		return orderId;
	}
	@Override
	public int getMaxOrderId() {
		return orderDetailsDao.getMaxOrderId();
	}

}
