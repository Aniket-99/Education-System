package com.training.educationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/educationsystem")
public class EducationSystemController {
	
	// Test route
	@GetMapping("/hello")
	public String sayHi() {
		return "hi";
	}
	
	// Start implementing the controller from here
	
	
	
	
}
