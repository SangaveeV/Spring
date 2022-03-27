package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderTransaction {
	@Id
	private int transaction_Id;
	private int order_Id;
	private int coffee_Id;
	private int addon_Id;
	public OrderTransaction() {
		
	}
	public OrderTransaction(int transaction_Id, int order_Id, int coffee_Id, int addon_Id) {
		super();
		this.transaction_Id = transaction_Id;
		this.order_Id = order_Id;
		this.coffee_Id = coffee_Id;
		this.addon_Id = addon_Id;
	}
	public int getTransaction_Id() {
		return transaction_Id;
	}
	public void setTransaction_Id(int transaction_Id) {
		this.transaction_Id = transaction_Id;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public int getCoffee_Id() {
		return coffee_Id;
	}
	public void setCoffee_Id(int coffee_Id) {
		this.coffee_Id = coffee_Id;
	}
	public int getAddon_Id() {
		return addon_Id;
	}
	public void setAddon_Id(int addon_Id) {
		this.addon_Id = addon_Id;
	}
	@Override
	public String toString() {
		return "OrderTransaction [transaction_Id=" + transaction_Id + ", order_Id=" + order_Id + ", coffee_Id="
				+ coffee_Id + ", addon_Id=" + addon_Id + "]";
	}
	

}
