package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.OrderDetails;
import com.sangavee.model.service.OrderDetailsService;

@CrossOrigin("*")
@RestController
public class OrderDetailsJsonResource {
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@PostMapping(path="/order/{id}/{customerId}/{voucherId}",produces = "application/json")
	public OrderDetails CreateOrder(@PathVariable("id")int orderId,@PathVariable("customerId")int customerId,@PathVariable("voucherId") int voucherId) {		
		return orderDetailsService.CreateOrder(orderId, customerId, voucherId);
	}
	
	@GetMapping(path="/orderId",produces = "application/json")
	public int getMaxOrderId() {
		return orderDetailsService.getMaxOrderId();
	}
	
}
