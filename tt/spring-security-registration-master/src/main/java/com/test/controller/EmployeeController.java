package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

@RequestMapping(value = "v1/")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@RequestMapping(value = "employees", method = RequestMethod.GET)
	public ResponseEntity<?> returnListEmployee() {
		List<Employee> emp = service.getList();
		ResponseEntity<?> response = new ResponseEntity<>(emp, HttpStatus.OK);
		return response;
	}

}
