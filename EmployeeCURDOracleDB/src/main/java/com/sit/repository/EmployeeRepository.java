package com.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sit.entity.Employee;
@Component
//@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}