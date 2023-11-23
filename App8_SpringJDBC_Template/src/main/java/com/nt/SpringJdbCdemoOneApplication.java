package com.nt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbCdemoOneApplication implements CommandLineRunner {

	@Autowired
	RegDetailsRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbCdemoOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		RegDetailsRepository
//		repo.createTable();
//		repo.addRecords();
//		repo.deleteRecord();
//		repo.updateRecord();
//		repo.setDynamicValuesToSQLQuery(56,"Puja");
//		repo.paramSetterByAnonymousClass(33,"Ankur");
		repo.getAllRecordsUsingRowMapper();

	}
}