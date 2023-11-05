package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sit.entity.Employee;
import com.sit.service.EmployeeService;

@Component
//@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	public Employee createEmployee(Employee empDetails) {
		return service.createEmployee(empDetails);
	}

	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	public Employee updateEmployee(Employee newEmployee) {
		return service.updateEmployee(newEmployee);
	}

	public void deleteEmployee(int empId) {
		service.deleteEmployeeByID(empId);
	}

	public Employee getEmployeeById(int empId) {
		Employee emp = service.getEmployeeByEmpId(empId);
		return emp;
	}
}
