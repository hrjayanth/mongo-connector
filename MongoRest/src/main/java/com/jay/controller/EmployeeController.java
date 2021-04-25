package com.jay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jay.service.MongoService;

@RestController
public class EmployeeController {

	@Autowired
	MongoService service;

	@GetMapping(path = "/insert")
	public String insertEmployee() {
		return service.insert();
	}

}
