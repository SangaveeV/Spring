package com.sangavee.model.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangavee.model.bean.Coffee;
import com.sangavee.model.dao.CoffeeDao;
import com.sangavee.model.dao.CoffeeDaoImpl;

@Service("CoffeeService")
public class CoffeeServiceImpl implements CoffeeService {

	@Autowired
	private CoffeeDao coffeeDao;
	
	public void setCoffeeDao(CoffeeDao coffeeDao) {
		this.coffeeDao = coffeeDao;
	}

	@Override
	public ArrayList<Coffee> getAllCoffee() {
		ArrayList<Coffee> coffeeList=coffeeDao.getAllCoffee();
		return coffeeList;
	}

	@Override
	public double getPriceByNameSize(String name, String size) {
		double price=coffeeDao.getPriceByNameSize(convertToUpperCase(name),convertToUpperCase(size));
		return price;
	}
	
	public String convertToUpperCase(String name) {
		return name.toUpperCase();
	}

	@Override
	public double getPriceById(int Id) {
		return coffeeDao.getPriceById(Id);
	}

	@Override
	public int getCoffeeId(String name, String size) {
		return coffeeDao.getCoffeeId(convertToUpperCase(name),convertToUpperCase(size));
	}

	@Override
	public Coffee getCoffeeById(int id) {
		return coffeeDao.getCoffeeById(id);
	}
	

}
