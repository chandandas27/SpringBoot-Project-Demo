package com.chandan.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.springbootdemo.model.Employee;
import com.chandan.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
		
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeById(id);
		
	}
}
