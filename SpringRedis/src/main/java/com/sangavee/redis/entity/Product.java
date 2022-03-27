package com.sangavee.redis.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String productName;
	private int quantity;
	private BigDecimal price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String productName, int quantity, BigDecimal price) {
		super();
		this.id = id;
		this.productName = productName;
		this.quantity = quantity;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}
	
}
