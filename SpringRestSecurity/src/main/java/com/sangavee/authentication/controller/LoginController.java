package com.sangavee.authentication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String showLoginPage(ModelMap model) {
		model.put("name", "Aashu");
		return "welcome";
	}
	
	

}
