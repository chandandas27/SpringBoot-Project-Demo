package com.chandan.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.chandan.springbootdemo.error.EmployeeNotFoundException;
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

	@Override
	public List<Employee> getAllEmployees() {
		return employees;
	}

	@Override
	public Employee getEmployeeById(String id) {
		return employees
				.stream()
				.filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
				.findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException(""+ "Employee not found with Id:"+id));

	}

	@Override
	public String deleteEmployeeById(String id) {
		Employee employee
				= employees
				.stream()
				.filter(e->e.getEmployeeId().equalsIgnoreCase(id))
				.findFirst()
				.get();

		employees.remove(employee);
		return "Employee deleted with the id: "+id;
	}

}
