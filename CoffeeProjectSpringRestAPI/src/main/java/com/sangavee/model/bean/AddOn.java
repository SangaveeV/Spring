package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {
	@Id
	private int addOnId;
	private String addOnName ;
	private double price;
	public AddOn() {
		
	}
	
	public AddOn(int addOnId, String addOnName, double price) {
		super();
		this.addOnId = addOnId;
		this.addOnName = addOnName;
		this.price = price;
	}

	public int getAddOnId() {
		return addOnId;
	}
	public void setAddOnId(int addOnId) {
		this.addOnId = addOnId;
	}
	public String getAddOnName() {
		return addOnName;
	}
	public void setAddOnName(String addOnName) {
		this.addOnName = addOnName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AddOn [AddOn_Id=" + addOnId + ", AddOnName=" + addOnName + ", price=" + price + "]";
	}
	
	
	

}
