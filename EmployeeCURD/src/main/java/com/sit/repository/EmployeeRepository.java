package com.sit.repository;

import java.util.LinkedList;
import java.util.List;

import com.sit.bean.Employee;

// ctrl + shift+S+O => importing the packages
public class EmployeeRepository {

	static public List employeeList = new LinkedList();

	public Employee createEmployee(Employee empDetails) {
		employeeList.add(empDetails);
		return empDetails;
	}

	// real all employee details
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	public Employee updateEmployee(Employee newEmployee) {
		Employee existedEmployee = null;
		int index = 0;
		int newEmpId = newEmployee.getEmpId();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee emp = (Employee) employeeList.get(i);
			if (emp.getEmpId() == newEmpId) {
				existedEmployee = emp;
				index = i;
				break;
			}
		}
		System.out.println("Existed employee detais" + existedEmployee);
		existedEmployee.setEmpName("Xys");
		employeeList.add(index, existedEmployee);
		return existedEmployee;
	}

	public void deleteEmployee(int empId) {
		int index = 0;

		for (int i = 0; i < employeeList.size(); i++) {
			Employee emp = (Employee) employeeList.get(i);
			if (emp.getEmpId() == empId) {
				index = i;
				break;
			}
		}

		// removing/deleting element based on Id and index
		employeeList.remove(index);

	}
}
