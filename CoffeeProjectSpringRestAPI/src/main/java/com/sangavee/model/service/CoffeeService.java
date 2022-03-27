package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.Coffee;
import com.sangavee.model.bean.Coffees;

public interface CoffeeService {

	Coffees getAllCoffee();
	double getPriceByNameSize(String name, String size);
	double getPriceById(int Id);
	int getCoffeeId(String name,String size);
	Coffee getCoffeeById(int id);
}
