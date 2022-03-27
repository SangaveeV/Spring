package com.sangavee.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.bean.OrderTransactions;
import com.sangavee.model.dao.OrderTransactionDao;

@Service("OrderTransaction")
public class OrderTransactionServiceImpl implements OrderTransactionService {
	@Autowired
	private OrderTransactionDao orderTran;
	
	public void setOrderTran(OrderTransactionDao orderTran) {
		this.orderTran = orderTran;
	}

	@Override
	public OrderTransaction createOrderTran(int orderId, int coffeeId, int addOnId){
		
		
		int orderTId=0;
		orderTId = orderTran.getMaxOrderTranId();
		orderTId = orderTId+1;
		OrderTransaction orderTransaction=orderTran.createOrderTran(orderTId,orderId, coffeeId, addOnId);
		return orderTransaction;
	}

	@Override
	public OrderTransactions getOrderTranByOrderID(int orderId)  {
		OrderTransactions orderTransactions=new OrderTransactions();
		orderTransactions.setOrderTransactions(orderTran.getOrderTranByCustOrderID(orderId));
		return orderTransactions;
	}

	@Override
	public int getMaxOrderTranId() {
		return orderTran.getMaxOrderTranId();
	}

}
