package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Employee;
import com.example.demo.repository.EmployeesRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class EmployeesController {
	
	@Autowired
	EmployeesRepository nRepo;
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> readEmployees () {
		return new ResponseEntity<List<Employee>>(nRepo.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(nRepo.save(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> readEmployee (@PathVariable Long id) {
		return new ResponseEntity<Employee>(nRepo.findById(id).get(), HttpStatus.OK);
	}
}
















