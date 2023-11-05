package com.sit.bean;

public class Employee {
	// bean properties
	private Integer empId; // data hiding
	private String empName;
	private Integer salary;

	public Employee() {
		// TODO Auto-generated constructor stub
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
