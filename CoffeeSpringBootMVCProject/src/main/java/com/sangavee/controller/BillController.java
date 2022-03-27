package com.sangavee.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.Bill;
import com.sangavee.model.bean.Coffee;
import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.service.AddOnService;
import com.sangavee.model.service.BillService;
import com.sangavee.model.service.CoffeeService;

@CrossOrigin("*")
@Controller
public class BillController {

	@Autowired
	private BillService billService;
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private AddOnService addOnService;

	private CustomerController customerController=new CustomerController();
	int orderId;
	
	@RequestMapping(value="/getCoffee", params="checkOut")
	public String coffeeBillController() {
		//return new ModelAndView("BillGeneration");
		return "forward:/billPage";
	}
	
	@RequestMapping(value="/getAddOn", params="addOnCheckOut")
	public String addOnBillController() {
		return "forward:/billPage";
	}
	
	@RequestMapping("/billPage")
	public ModelAndView billGenerationPageController() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("billCoffeeList",getCoffee());
		mv.addObject("billAddOnList",getAddOn());
		mv.setViewName("BillGeneration");
		return mv;
	}
	
	@RequestMapping("/getBill")
	public ModelAndView billGenerationController(HttpServletRequest  request) {
		ModelAndView mv=new ModelAndView();
		String discount=request.getParameter("voucher");
		String voucher=null;
		if(discount!="") {
			voucher=discount;
		}
		orderId=customerController.getOrderId();
		billService.addBill(orderId, voucher);
		String customerName=customerController.getCustomerName();
		Bill bill=billService.getInvoiceByOrderId(orderId);
		mv.addObject("bill",bill);
		mv.addObject("customer",customerName);
		mv.setViewName("Bill");
		return mv;
	}
	
	@ModelAttribute("billCoffeeList")
	public ArrayList<Coffee> getCoffee(){
		ArrayList<Coffee> coffeeList=new ArrayList<Coffee>();
		orderId=customerController.getOrderId();
		ArrayList<OrderTransaction> transList=billService.getOrderList(orderId);
		for(OrderTransaction trans:transList) {
			if(trans.getCoffee_Id()!=0) {
				Coffee coffee=coffeeService.getCoffeeById(trans.getCoffee_Id());
				coffeeList.add(coffee);
			}
		}
		return coffeeList;
	}
	
	@ModelAttribute("billAddOnList")
	public ArrayList<AddOn> getAddOn(){
		ArrayList<AddOn> addOnList=new ArrayList<AddOn>();
		orderId=customerController.getOrderId();
		ArrayList<OrderTransaction> transList=billService.getOrderList(orderId);
		for(OrderTransaction trans:transList) {
			if(trans.getAddon_Id()!=0) {
				AddOn addOn=addOnService.getAddOnById(trans.getAddon_Id());
				addOnList.add(addOn);
			}
		}	
		return addOnList;
	}
	
	
	
	
}
