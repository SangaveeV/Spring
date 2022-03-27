package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.Coffee;
import com.sangavee.model.bean.Coffees;
import com.sangavee.model.service.CoffeeService;

@CrossOrigin("*")
@RestController
public class CoffeeJsonResource {

	@Autowired
	private CoffeeService coffeeService;
	
	@GetMapping(path="/coffees",produces = "application/json")
	public Coffees getAllCoffees() {
		return coffeeService.getAllCoffee();
	}
	
	@GetMapping(path="/coffeePrice/{name}/{size}",produces = "application/json")
	public double getCoffeePrice(@PathVariable("name")String name,@PathVariable("size")String size) {
		return coffeeService.getPriceByNameSize(name, size);
	}

	@GetMapping(path="/coffeePrice/{id}",produces = "application/json")
	public double getPriceById(@PathVariable("id")int id) {
		return coffeeService.getPriceById(id);
	}
	
	@GetMapping(path="/coffeeId/{name}/{size}",produces = "application/json")
	public int getCoffeeId(@PathVariable("name")String name,@PathVariable("size")String size) {
		return coffeeService.getCoffeeId(name,size);
	}
	
	@GetMapping(path="/coffee/{id}",produces = "application/json")
	public Coffee getCoffeeById(@PathVariable("id")int id) {
		return coffeeService.getCoffeeById(id);
	}
		
}
