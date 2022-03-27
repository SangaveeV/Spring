package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AddOn {
	@Id
	private int addOn_Id;
	private String addOnName ;
	private double price;
	public AddOn() {
		
	}
	
	public AddOn(int addOn_Id, String addOnName, double price) {
		super();
		this.addOn_Id = addOn_Id;
		this.addOnName = addOnName;
		this.price = price;
	}

	public int getAddOn_Id() {
		return addOn_Id;
	}
	public void setAddOn_Id(int addOn_Id) {
		this.addOn_Id = addOn_Id;
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
		return "AddOn [AddOn_Id=" + addOn_Id + ", AddOnName=" + addOnName + ", price=" + price + "]";
	}
	
	
	

}
