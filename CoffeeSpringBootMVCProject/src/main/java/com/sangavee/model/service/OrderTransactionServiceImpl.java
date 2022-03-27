package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.dao.OrderTransactionDao;
import com.sangavee.model.dao.OrderTransactionDaoImpl;

@Service("OrderTransaction")
public class OrderTransactionServiceImpl implements OrderTransactionService {
	@Autowired
	private OrderTransactionDao orderTran;
	
	public void setOrderTran(OrderTransactionDao orderTran) {
		this.orderTran = orderTran;
	}

	@Override
	public int createOrderTran(int orderId, int coffeeId, int addOnId){
		
		
		int orderTId=0;
		orderTId = orderTran.getMaxOrderTranId();
		orderTId = orderTId+1;
		orderTran.createOrderTran(orderTId,orderId, coffeeId, addOnId);
		return orderId;
	}

	@Override
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId)  {
		ArrayList<OrderTransaction> transList= orderTran.getOrderTranByCustOrderID(orderId);
		return transList;
	}

	@Override
	public int getMaxOrderTranId() {
		return orderTran.getMaxOrderTranId();
	}

}
