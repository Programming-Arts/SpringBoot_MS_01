package com.sit;

import java.util.ArrayList;
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
//		RegistrationDetails detailsBasedOnName = repo.getDetailsBasedOnName("yash");
//		System.out.println(detailsBasedOnName);
//		System.out.println("----------------------------------");
//		List<RegistrationDetails> list = repo.getDetailsBasedOnNameandContact(123, "Ram");
//		System.out.println("====Based on Contact and Name====");

//		List<RegistrationDetails> list = repo.findByContact(123);
//		List<RegistrationDetails> list = repo.findRegistrationDetailsByContactAndEmail(123, "test@gmail.com");
//		List<RegistrationDetails> list = repo.findRegistrationDetailsByEmailContaining("gmail");
		List<Integer> ids=new ArrayList<>();
		ids.add(10);
		ids.add(20);
//		List<RegistrationDetails> list = repo.findRegistrationDetailsByPersonIDIn(ids);


//		list.stream().forEach(obj -> {
//
//			System.out.println(
//					obj.getPersonName() + " " + obj.getEmail() + " " + obj.getContact() + " " + obj.getPersonAge());
//		});

	}

}
