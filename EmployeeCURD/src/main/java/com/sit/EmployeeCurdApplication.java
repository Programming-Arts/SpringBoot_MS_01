package com.sit;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sit.bean.Employee;
import com.sit.controller.EmployeeController;

@SpringBootApplication
public class EmployeeCurdApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCurdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeController empController = new EmployeeController();

		// create employee
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setEmpName("Shreyas");
		emp1.setSalary(10000);

		Employee emp2 = new Employee(2, "Rutuja", 20000);
		Employee emp3 = new Employee(3, "Yash", 30000);

		System.out.println("===Create===");
		empController.createEmployee(emp1);
		empController.createEmployee(emp2);
		empController.createEmployee(emp3);
		// see all employees

		System.out.println("===Read===");
		List allEmployees = empController.getAllEmployees();
		System.out.println("All employees details");
		System.out.println(allEmployees);
		System.out.println("===Update===");
		int emp2Id=emp2.getEmpId();
		empController.deleteEmployee(emp2Id);
		
		System.out.println("All employees details after deleting " );
		System.out.println(allEmployees);
	}

}
