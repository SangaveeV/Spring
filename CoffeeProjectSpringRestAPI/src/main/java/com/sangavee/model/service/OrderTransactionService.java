package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.bean.OrderTransactions;

public interface OrderTransactionService {
	public OrderTransaction createOrderTran(int orderId, int coffeeId, int addOnId);
	public OrderTransactions getOrderTranByOrderID(int orderId);
	public int getMaxOrderTranId();
	
}
