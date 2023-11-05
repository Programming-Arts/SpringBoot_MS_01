package com.sit.controller;

import java.util.List;

import com.sit.bean.Employee;
import com.sit.service.EmployeeService;

public class EmployeeController {
	private static EmployeeService service = new EmployeeService();

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
		service.deleteEmployee(empId);
	}

}
