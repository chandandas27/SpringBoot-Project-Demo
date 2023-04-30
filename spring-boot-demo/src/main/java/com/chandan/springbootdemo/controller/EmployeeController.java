package com.chandan.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.chandan.springbootdemo.model.Employee;
import com.chandan.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
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
	@DeleteMapping("/{id}")
	public String deleteEmployeeById(@PathVariable String id){
		return employeeService.deleteEmployeeById(id);

	}
}
