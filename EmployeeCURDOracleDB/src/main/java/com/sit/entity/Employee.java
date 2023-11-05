package com.sit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class Employee {
	// bean properties
	@Id
	@Column(name = "emp_id")
	private Integer empId; // data hiding
	@Column(name = "emp_name")
	private String empName;
	@Column(name = "sal")
	private Integer salary;

	public Employee() {

	}

	// param constructor: shift+ctrl+O+R
	public Employee(Integer empId, String empName, Integer salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}

	// getter setter :shift+ctrl+S+R
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	// shift+alt+S+S
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}

}
