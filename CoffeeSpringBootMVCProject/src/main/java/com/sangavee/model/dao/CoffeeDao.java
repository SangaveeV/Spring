package com.sangavee.model.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sangavee.model.bean.Coffee;

public interface CoffeeDao {

	ArrayList<Coffee> getAllCoffee();
	double getPriceByNameSize(String name, String size);
	double getPriceById(int Id);
	int getCoffeeId(String name,String size);
	Coffee getCoffeeById(int id);
}
