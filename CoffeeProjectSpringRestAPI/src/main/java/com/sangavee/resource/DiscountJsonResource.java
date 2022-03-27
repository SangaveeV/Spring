package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.service.DiscountService;

@CrossOrigin("*")
@RestController
public class DiscountJsonResource {

	@Autowired
	private DiscountService discountService;
	
	@GetMapping(path="/discount/{voucher}",produces = "application/json")
	public double getDiscountByVoucher(@PathVariable("voucher")String voucher) {
		return discountService.getDiscountByVoucher(voucher);
	}
	
}
