package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.Bill;
import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.bean.OrderTransactions;

public interface BillService {

	public Bill addBill(int orderId, String voucher);
	public Bill getInvoiceByOrderId(int orderId);
}
