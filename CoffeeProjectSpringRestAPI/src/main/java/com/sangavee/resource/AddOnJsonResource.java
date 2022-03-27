package com.sangavee.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sangavee.model.bean.AddOn;
import com.sangavee.model.bean.AddOns;
import com.sangavee.model.service.AddOnService;

@CrossOrigin("*")
@RestController
public class AddOnJsonResource {

	@Autowired
	private AddOnService addOnService;
	
	@GetMapping(path="/addOns",produces = "application/json")
	public AddOns getAllAddOns() {
		return addOnService.getAllAddOn();
	}
	
	@GetMapping(path="/addOnPrice/{name}",produces = "application/json")
	public double getAddOnPriceByName(@PathVariable("name")String name) {
		return addOnService.getAddOnPriceByName(name);		
	}
	
	@GetMapping(path="/addOnPriceById/{id}",produces = "application/json")
	public double getAddOnPriceById(@PathVariable("id")int id){
		return addOnService.getAddOnPriceById(id);
	}
	
	@GetMapping(path="/addOnId/{name}",produces = "application/json")
	public int getAddOnId(@PathVariable("name")String name){
		return addOnService.getAddOnId(name);
	}
	
	@GetMapping(path="/addOn/{id}",produces = "application/json")
	public AddOn getAddOnById(@PathVariable("id")int id)  {
		return addOnService.getAddOnById(id);
	}
}
