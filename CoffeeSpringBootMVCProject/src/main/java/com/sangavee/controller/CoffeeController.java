package com.sangavee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sangavee.model.bean.Coffee;
import com.sangavee.model.service.CoffeeService;
import com.sangavee.model.service.OrderTransactionService;

@CrossOrigin("*")
@Controller
public class CoffeeController {

	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private OrderTransactionService orderTransactionService;
	
	private CustomerController customerController=new CustomerController();
	int orderId;
	
	@RequestMapping("/coffee")
	public ModelAndView coffeePageController() {
		ModelAndView mv=new ModelAndView();
		ArrayList<Coffee> coffeeList=coffeeService.getAllCoffee();
		mv.addObject("coffeeList",coffeeList);
		mv.addObject("coffee",new Coffee());
		mv.setViewName("Coffee");
		return mv;
	}
	
	@ModelAttribute("coffeeName")
	public List<String> getCoffeeNames(){
		ArrayList<Coffee> coffeeList=coffeeService.getAllCoffee();
		List<String> names=coffeeList.stream().map(Coffee::getCoffeeName).distinct().collect(Collectors.toList());
		return names;
	}
	
	@ModelAttribute("coffeeSize")
	public List<String> getCoffeesize(){
		ArrayList<Coffee> coffeeList=coffeeService.getAllCoffee();
		List<String> size=coffeeList.stream().map(Coffee::getCoffeeSize).distinct().collect(Collectors.toList());
		return size;
	}
	
	@RequestMapping(value="/getCoffee", params="selectCoffee")
	public String selectCoffeeController(@ModelAttribute Coffee coffee) {
		orderId=customerController.getOrderId();
		int coffeeId=coffeeService.getCoffeeId(coffee.getCoffeeName(), coffee.getCoffeeSize());
		orderTransactionService.createOrderTran(orderId, coffeeId, 0);
		return "forward:/coffee";
	}
	
	@RequestMapping("/Last")
	public ModelAndView mainPageController() {
		return new ModelAndView("Last");
	}
}
