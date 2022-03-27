package com.sangavee.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.OrderTransaction;


public interface OrderTransactionDao {
	public int createOrderTran(int orderTranId , int orderId, int coffeeId, int addOnID);
	public ArrayList<OrderTransaction> getOrderTranByCustOrderID(int orderId);
	public int getMaxOrderTranId();
	

}
