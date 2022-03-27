package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.Coffee;

public interface CoffeeService {

	ArrayList<Coffee> getAllCoffee();
	double getPriceByNameSize(String name, String size);
	double getPriceById(int Id);
	int getCoffeeId(String name,String size);
	Coffee getCoffeeById(int id);
}
