package com.training.educationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.educationsystem.entities.Student;
import com.training.educationsystem.services.StudentService;

@RestController
@RequestMapping("/api/educationsystem")
public class EducationSystemController {

	@Autowired
	private StudentService studentService;

	// Test route
	@GetMapping("/hello")
	public String sayHi() {
		return "hi";
	}

	// Start implementing the controller from here

}
