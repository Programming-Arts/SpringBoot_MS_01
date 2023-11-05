package com.sit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sit.entity.Employee;
import com.sit.repository.EmployeeRepository;

@Component
//@Service
public class EmployeeService {

	@Autowired // create object of EmployeeRepository and inject in EmployeeService
	EmployeeRepository repo;

	public Employee createEmployee(Employee empDetails) {
		return repo.save(empDetails);
	}

	public List<Employee> getAllEmployees() {

		return repo.findAll();
	}

	public Employee updateEmployee(Employee newEmployee) {
		// get id from new Object
		int existedEmpId = newEmployee.getEmpId(); // 3

		// ge the complete object from databse whose id = existedEmpId
		// it will return Optional EMployee
		Optional<Employee> existedEmp = repo.findById(existedEmpId);

		// get actual Employee object from Optional Employee
		Employee emp = existedEmp.get();
		System.out.println("existed employee details: " + emp);

		// get new name to update from new Object i. e. new Employee
		String newName = newEmployee.getEmpName();
		// updating old object property to new value
		int newSal = newEmployee.getSalary();
		emp.setSalary(newSal);
		emp.setEmpName(newName);

		// save updadted employee object to database
		Employee savedEmployee = repo.save(emp);
		return savedEmployee;
	}

	public void deleteEmployeeByID(int empId) {
		repo.deleteById(empId);
	}

	public Employee getEmployeeByEmpId(int empId) {
		Optional<Employee> optEmp = repo.findById(empId);
		Employee actualEmpObject = null;
		boolean isObjectPresent = optEmp.isPresent();

		if (isObjectPresent == true)
			actualEmpObject = optEmp.get();
		else 
			throw new RuntimeException("Employee is not found with id="+empId);
		return actualEmpObject;
	}
}
