package com.sit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sit.entity.RegistrationDetails;
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
		RegistrationDetails detailsBasedOnName = 
				repo.getDetailsBasedOnName("yash");
		System.out.println(detailsBasedOnName);
		System.out.println("----------------------------------");
		List<RegistrationDetails> list=repo.getDetailsBasedOnNameandContact( 123,"Ram");
		System.out.println("====Based on Contact and Name====");
		System.out.println(list);

	}

}
