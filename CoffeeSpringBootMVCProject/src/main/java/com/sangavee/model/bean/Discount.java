package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Discount {
	@Id
	private int voucherId;
	private String voucher;
	private double discount;
	
	public Discount() {
		
	}
	public Discount(int voucherId, String voucher, double discount) {
		super();
		this.voucherId = voucherId;
		this.voucher = voucher;
		this.discount = discount;
	}
	public int getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}
	public String getVoucher() {
		return voucher;
	}
	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Discount [voucherId=" + voucherId + ", voucher=" + voucher + ", discount=" + discount + "]";
	}
	

}
