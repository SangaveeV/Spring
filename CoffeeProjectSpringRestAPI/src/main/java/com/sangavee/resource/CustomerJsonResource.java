package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.Customer;
import com.sangavee.model.service.CustomerService;

@CrossOrigin("*")
@RestController
public class CustomerJsonResource {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path="/customer/{name}/{phone}",produces = "application/json")
	public Customer addCustomer(@PathVariable("name")String customerName, @PathVariable("phone")long phoneNumber) {
		return customerService.addCustomer(customerName, phoneNumber);
	}
	
	@GetMapping(path="/customer/{phone}",produces = "application/json")
	public String getCustomerNamebyPhone(@PathVariable("phone")long phone) {
		return customerService.getCustomerNamebyPhone(phone);
	}
	
	@GetMapping(path="/customerId/{phone}",produces = "application/json")
	public int getCustomerId(@PathVariable("phone")long phone) {
		return customerService.getCustomerId(phone);
	}


}
