package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.Bill;
import com.sangavee.model.bean.OrderTransaction;

public interface BillService {

	public void addBill(int orderId, String voucher);
	public Bill getInvoiceByOrderId(int orderId);
	public ArrayList<OrderTransaction> getOrderList(int orderId);
}
