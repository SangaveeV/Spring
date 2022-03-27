package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.Bill;
import com.sangavee.model.service.BillService;

@CrossOrigin("*")
@RestController
public class BillJsonResource {

	@Autowired
	private BillService billService;
	
	@PostMapping(path="/bills/{id}/{voucher}",produces = "application/json")
	public Bill addBill(@PathVariable("id")int orderId, @PathVariable("voucher")String voucher) {
		return billService.addBill(orderId, voucher);
	}
	
	@GetMapping(path="/bills/{id}",produces = "application/json")
	public Bill getInvoiceByOrderId(@PathVariable("id")int orderId){
		return billService.getInvoiceByOrderId(orderId);
	}

	
}
