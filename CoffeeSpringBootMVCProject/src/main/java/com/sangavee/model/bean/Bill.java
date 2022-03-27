package com.sangavee.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bill {
	@Id
	private int bill_Id;
	private int order_Id;
	private double amount;
	private double discount;
	private double netValue;
	private double gst;
	private double serviceTax;
	private double totalAmount;
	private Date billDate;
	public Bill() {
		
	}
	public Bill(int bill_Id, int order_Id, double amount, double discount, double netValue, double gst,
			double serviceTax, double totalAmount, Date billDate) {
		super();
		this.bill_Id = bill_Id;
		this.order_Id = order_Id;
		this.amount = amount;
		this.discount = discount;
		this.netValue = netValue;
		this.gst = gst;
		this.serviceTax = serviceTax;
		this.totalAmount = totalAmount;
		this.billDate = billDate;
	}

	public int getBill_Id() {
		return bill_Id;
	}
	public void setBill_Id(int billId) {
		this.bill_Id = billId;
	}
	public int getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getNetValue() {
		return netValue;
	}
	public void setNetValue(double netValue) {
		this.netValue = netValue;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getServiceTax() {
		return serviceTax;
	}
	public void setServiceTax(double serviceTax) {
		this.serviceTax = serviceTax;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	@Override
	public String toString() {
		return "Bill [bill_Id=" + bill_Id + ", order_Id=" + order_Id + ", amount=" + amount + ", discount=" + discount
				+ ", netValue=" + netValue + ", gst=" + gst + ", serviceTax=" + serviceTax + ", totalAmount="
				+ totalAmount + ", billDate=" + billDate + "]";
	} 
	
	

}
