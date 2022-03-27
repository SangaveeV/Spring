package com.sangavee.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.Customer;
import com.sangavee.model.dao.CustomerDao;
import com.sangavee.model.dao.CustomerDaoImpl;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
		
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void addCustomer(String customerName, long phoneNumber) {
		customerDao.addCustomer(customerDao.getMaxCustomerId()+1, customerName, phoneNumber);
	}

	@Override
	public String getCustomerNamebyPhone(long phone) {
		String name=null;

			Customer customer = customerDao.getCustomerbyPhone(phone);
			if(customer==null) {
				return null;
			}
			name=customer.getCustomerName();
		
	
		return name;

	}
	

	@Override
	public int getCustomerId(long phone) {
		Customer customer=customerDao.getCustomerbyPhone(phone);
		return customer.getCustomer_Id();
	}

	@Override
	public Customer getCustomer(long phone) {
		return customerDao.getCustomerbyPhone(phone);
	}

}
