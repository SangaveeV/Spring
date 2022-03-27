package com.sangavee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sangavee.model.bean.Customer;
import com.sangavee.model.service.CustomerService;
import com.sangavee.model.service.OrderDetailsService;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	static int orderId;
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	@ModelAttribute("custOrderId")
	public int getOrderId() {
		return orderId;
	}
	
	static String customerName;
	
	@ModelAttribute("currentCustomerName")
	public String getCustomerName() {
		return customerName;
	}

	@RequestMapping("/")
	public ModelAndView customerPageController() {
		return new ModelAndView("Customer","customer",new Customer());
	}
	
	@RequestMapping("/orderCoffee")
	public ModelAndView customerController(@ModelAttribute Customer customer) {
		ModelAndView mv=new ModelAndView();
		Customer cust=customerService.getCustomer(customer.getPhone());
		customerName=customerService.getCustomerNamebyPhone(customer.getPhone());
		String message=null;
		String greet=null;
		if(cust!=null) {
			greet="Welcome ";
			message=customerName;
			mv.setViewName("WelcomeCustomer");
			mv.addObject("greet",greet);
			mv.addObject("message", message);
			orderId=orderDetailsService.getMaxOrderId()+1;
			orderId=orderDetailsService.CreateOrder(orderId, cust.getCustomer_Id(), getCurrentDate().toString(), 0);
		}
		else {
			greet="Sorry, You are a New Customer";
			message="Please Enter your Name";
			mv.setViewName("GetCustomer");
			mv.addObject("greet",greet);
			mv.addObject("message", message);
			mv.addObject("phone",customer.getPhone());
		}
		
		return mv;
	}
	
	@RequestMapping("/getCustomer")
	public ModelAndView GetCustomerPageController(@ModelAttribute Customer customer) {
		ModelAndView mv=new ModelAndView();
		customerService.addCustomer(customer.getCustomerName(), customer.getPhone());
		int customerId=customerService.getCustomerId(customer.getPhone());
		String greet="Welcome ";
		customerName=customer.getCustomerName();
		mv.setViewName("WelcomeCustomer");
		mv.addObject("greet",greet);
		mv.addObject("message", customerName);
		orderId=orderDetailsService.getMaxOrderId()+1;
		orderId=orderDetailsService.CreateOrder(orderId, customerId, getCurrentDate().toString(), 0);
		return mv;
	}


}
