package com.chandan.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chandan.springbootdemo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> employees = new ArrayList<>();
	
	@Override
	public Employee save(Employee employee) {
		
		if(employee.getEmployeeId() == null || employee.getEmailId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		employees.add(employee);
			return employee;
	}

}
