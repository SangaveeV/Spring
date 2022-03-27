package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.OrderTransaction;

public interface OrderTransactionService {
	public int createOrderTran(int orderId, int coffeeId, int addOnId);
	public ArrayList<OrderTransaction> getOrderTranByOrderID(int orderId);
	public int getMaxOrderTranId();
	
}
