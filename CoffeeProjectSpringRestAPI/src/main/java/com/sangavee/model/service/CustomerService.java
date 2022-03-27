package com.sangavee.model.service;

import java.sql.SQLException;

import com.sangavee.model.bean.Customer;

public interface CustomerService {

	Customer addCustomer(String customerName, long phoneNumber);
	String getCustomerNamebyPhone(long phone);
	int getCustomerId(long phone);
	Customer getCustomer(long phone);
}
