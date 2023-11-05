package com.sit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sit.controller.EmployeeController;
import com.sit.entity.Employee;

@SpringBootApplication
public class EmployeeCurd1Application implements CommandLineRunner {

	@Autowired
	private EmployeeController controller;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCurd1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		// create employee
//		Employee emp1 = new Employee();
//		emp1.setEmpId(1);
//		emp1.setEmpName("Shreyas");
//		emp1.setSalary(10000);
//
//		Employee emp2 = new Employee(2, "Rutuja", 20000);
//		Employee emp3 = new Employee(3, "Yash", 30000);
//		Employee emp4 = new Employee(4, "Ram", 40000);
//
//		controller.createEmployee(emp1);
//		System.out.println("EMployee 1 is stored");
//		controller.createEmployee(emp2);
//		System.out.println("EMployee 2 is stored");
//		controller.createEmployee(emp3);
//		System.out.println("EMployee 3 is stored");
//		controller.createEmployee(emp4);
//		System.out.println("EMployee 4 is stored");
//
//		System.out.println("Getting all employees from DB");
//		List<Employee> allEmployees = controller.getAllEmployees();
//
//		System.out.println(allEmployees);
//		System.out.println("Delete 4th Employee");
//		controller.deleteEmployee(4);
//		System.out.println("$th Employee is deleted");
//
//		allEmployees = controller.getAllEmployees();
//		System.out.println("After deletion Emps:");
//		System.out.println(allEmployees);
//		
//		Employee emp=new Employee(3, "Yash new", 40000);
//		controller.updateEmployee(emp);
		try {
			Employee employee = controller.getEmployeeById(13);
			System.out.println("Employee: " + employee);

			String name = employee.getEmpName();
			System.out.println("Name: " + name);
		} catch (Exception e) {
			System.out.println("Employee not found");
		}

	}

}
