package com.sangavee.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coffee {

	@Id
	private int coffee_Id;
	private String coffeeName;
	private String coffeeSize;
	private double price;
	public Coffee() {
		
	}
	public Coffee(int coffee_Id, String coffeeName, String coffeeSize, double price) {
		super();
		this.coffee_Id = coffee_Id;
		this.coffeeName = coffeeName;
		this.coffeeSize = coffeeSize;
		this.price = price;
	}
	public int getCoffee_Id() {
		return coffee_Id;
	}
	public void setCoffee_Id(int coffee_Id) {
		this.coffee_Id = coffee_Id;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getCoffeeSize() {
		return coffeeSize;
	}
	public void setCoffeeSize(String coffeeSize) {
		this.coffeeSize = coffeeSize;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Coffee [coffee_Id=" + coffee_Id + ", coffeeName=" + coffeeName + ", coffeeSize=" + coffeeSize
				+ ", price=" + price + "]";
	}

	
	
}
