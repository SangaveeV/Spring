package com.sangavee.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetails {
	@Id
	private int order_Id;
	private int customer_Id;
	private int voucherId;
	private Date orderDate;
	public OrderDetails() {
		
	}

	public OrderDetails(int order_Id, int customer_Id, Date orderDate,int voucherId) {
		super();
		this.order_Id = order_Id;
		this.customer_Id = customer_Id;
		this.voucherId = voucherId;
		this.orderDate = orderDate;
	}

	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDetails [order_Id=" + order_Id + ", customer_Id=" + customer_Id + ", voucherId=" + voucherId
				+ ", orderDate=" + orderDate + "]";
	}
	
	
}
