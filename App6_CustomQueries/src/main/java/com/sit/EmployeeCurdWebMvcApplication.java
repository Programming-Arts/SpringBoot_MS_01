package com.sit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sit.repo.RegistrationRepo;

@SpringBootApplication
public class EmployeeCurdWebMvcApplication implements CommandLineRunner {

	@Autowired
	private RegistrationRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCurdWebMvcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

	}

}
