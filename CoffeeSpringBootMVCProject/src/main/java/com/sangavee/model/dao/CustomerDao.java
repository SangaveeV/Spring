package com.sangavee.model.dao;

import java.sql.SQLException;

import com.sangavee.model.bean.Customer;

public interface CustomerDao {

	void addCustomer(int customerId, String customerName, long phoneNumber);
	Customer getCustomerbyPhone(long phone);
	int getMaxCustomerId();
}
