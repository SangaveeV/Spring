package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	private int customer_Id;
	private String customerName;
	private long phone;
	public Customer() {
		
	}
	public Customer(int customer_Id, String customerName, long phone) {
		super();
		this.customer_Id = customer_Id;
		this.customerName = customerName;
		this.phone = phone;
	}
	
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Customer [customer_Id=" + customer_Id + ", customerName=" + customerName + ", phone=" + phone + "]";
	}

}
