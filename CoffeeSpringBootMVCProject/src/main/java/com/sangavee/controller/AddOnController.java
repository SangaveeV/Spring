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

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.Coffee;
import com.sangavee.model.service.AddOnService;
import com.sangavee.model.service.OrderTransactionService;

@CrossOrigin("*")
@Controller
public class AddOnController {

	@Autowired
	private AddOnService addOnService;
	@Autowired
	private OrderTransactionService orderTransactionService;
	private CustomerController customerController=new CustomerController();
	int orderId;
	String coffeeName,coffeeSize;
	
	@RequestMapping(value="/getCoffee", params="addOn")
	public ModelAndView addOnPageController(@ModelAttribute Coffee coffee) {
		ModelAndView mv=new ModelAndView();
		ArrayList<AddOn> addOnList=addOnService.getAllAddOn();
		mv.addObject("addOnList",addOnList);
		mv.addObject("coffeeName",coffee.getCoffeeName());
		mv.addObject("coffeeSize",coffee.getCoffeeSize());
		coffeeName=coffee.getCoffeeName();
		coffeeSize=coffee.getCoffeeSize();
		mv.addObject("addOn", new AddOn());
		mv.setViewName("AddOn");
		return mv;
	}	
	
	@ModelAttribute("addOnName")
	public List<String> getAddOns(){
		ArrayList<AddOn> addOnList=addOnService.getAllAddOn();
		List<String> names=addOnList.stream().map(AddOn::getAddOnName).distinct().collect(Collectors.toList());
		return names;
	}
	
	@RequestMapping(value="/getAddOn", params="coffeeOrder")
	public String addOnCoffeeController(@ModelAttribute AddOn addOn) {
		orderId=customerController.getOrderId();
		int addOnId=addOnService.getAddOnId(addOn.getAddOnName());
		orderTransactionService.createOrderTran(orderId, 0, addOnId);
		return "forward:/coffee";		
	}
	
	@RequestMapping(value="/getAddOn", params="anotherAddOn")
	public ModelAndView anotherAddOnController(@ModelAttribute AddOn addOn) {
		orderId=customerController.getOrderId();
		int addOnId=addOnService.getAddOnId(addOn.getAddOnName());
		orderTransactionService.createOrderTran(orderId, 0, addOnId);
		ModelAndView mv=new ModelAndView();
		ArrayList<AddOn> addOnList=addOnService.getAllAddOn();
		mv.addObject("addOnList",addOnList);
		mv.addObject("addOn", new AddOn());
		mv.addObject("coffeeName",coffeeName);
		mv.addObject("coffeeSize",coffeeSize);
		mv.setViewName("AddOn");
		return mv;	
	}
}
