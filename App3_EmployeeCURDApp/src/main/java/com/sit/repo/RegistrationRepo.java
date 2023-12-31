package com.sit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sit.entity.RegistrationDetails;

@Repository
// it will make interface as repository layer or persistent layer interface to perform 
//persistent operations (DB related operations)
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, Integer> {

	// custom queries

	@Query(value = "select * from reg_details where person_name like 'Rahul'", nativeQuery = true)
	RegistrationDetails getDetailsBasedOnName();

}
