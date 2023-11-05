package com.sit.service;

import java.util.List;

import com.sit.bean.Employee;
import com.sit.repository.EmployeeRepository;

public class EmployeeService {

	static EmployeeRepository repo = new EmployeeRepository();

	public Employee createEmployee(Employee empDetails) {
		return repo.createEmployee(empDetails);
	}

	
	public List<Employee> getAllEmployees() {
		return repo.getAllEmployees();
	}

	public Employee updateEmployee(Employee newEmployee) {

		return repo.updateEmployee(newEmployee);
	}

	public void deleteEmployee(int empId) {
		repo.deleteEmployee(empId);
	}
}
