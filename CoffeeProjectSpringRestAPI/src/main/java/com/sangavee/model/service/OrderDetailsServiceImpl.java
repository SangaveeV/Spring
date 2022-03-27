package com.sangavee.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.OrderDetails;
import com.sangavee.model.dao.OrderDetailsDao;

@Service("OrderDetailsService")
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	private OrderDetailsDao orderDetailsDao;
	
	public void setOrderDetailsDao(OrderDetailsDao orderDetailsDao) {
		this.orderDetailsDao = orderDetailsDao;
	}
	@Override
	public OrderDetails CreateOrder(int orderId,int customerId, int voucherId) {		
		return orderDetailsDao.CreateOrder(orderId,customerId, voucherId);	
		
	}
	@Override
	public int getMaxOrderId() {
		return orderDetailsDao.getMaxOrderId();
	}

}
