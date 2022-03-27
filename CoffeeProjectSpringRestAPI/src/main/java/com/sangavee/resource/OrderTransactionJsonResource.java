package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.OrderTransaction;
import com.sangavee.model.bean.OrderTransactions;
import com.sangavee.model.service.OrderTransactionService;

@CrossOrigin("*")
@RestController
public class OrderTransactionJsonResource {

	@Autowired
	private OrderTransactionService orderTransactionService;
	
	@PostMapping(path="/orderTransaction/{id}/{coffeeId}/{addOnId}",produces = "application/json")
	public OrderTransaction createOrderTran(@PathVariable("id")int orderId,@PathVariable("coffeeId") int coffeeId,@PathVariable("addOnId") int addOnId){
		return orderTransactionService.createOrderTran(orderId, coffeeId, addOnId);
	}
	
	@GetMapping(path="/orderTransactions/{id}",produces = "application/json")
	public OrderTransactions getOrderTranByOrderID(@PathVariable("id")int orderId)  {
		return orderTransactionService.getOrderTranByOrderID(orderId);
	}
	
	@GetMapping(path="/orderTransactionId",produces = "application/json")
	public int getMaxOrderTranId() {
		return orderTransactionService.getMaxOrderTranId();
	}
}
