package com.sangavee.model.dao;

import com.sangavee.model.bean.Bill;

public interface BillDao {
	void addBill(int billId,int orderId, double amount, double discount, double netValue, double gst,double serviceTax, double totalAmount);
	Bill getInvoiceByOrderId(int orderId);
	public int getMaxBillId();

}
