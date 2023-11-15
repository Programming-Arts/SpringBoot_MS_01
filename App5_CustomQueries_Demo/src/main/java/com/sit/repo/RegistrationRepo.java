package com.sit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sit.entity.RegistrationDetails;

@Repository
// it will make interface as repository layer or persistent layer interface to perform 
//persistent operations (DB related operations)
public interface RegistrationRepo extends JpaRepository<RegistrationDetails, Integer> {

	// custom queries
	// named parameters
//	@Query(value = "select * from reg_details where person_name like :nameOfPerson", nativeQuery = true)
//	RegistrationDetails getDetailsBasedOnName(@Param("nameOfPerson") String name);
//
//	@Query(value = "select * from reg_details where person_name like :nameOfPerson or contact = :mobNo", nativeQuery = true)
//	List<RegistrationDetails> getDetailsBasedOnNameandContact(@Param("nameOfPerson") String name,
//			@Param("mobNo") Integer contact);

	
	@Query(value = "select * from reg_details where person_name like ?1", nativeQuery = true)
	RegistrationDetails getDetailsBasedOnName(String name);
	
	@Query(value = "select * from reg_details where person_name like ?2 or contact = ?1", nativeQuery = true)
	List<RegistrationDetails> getDetailsBasedOnNameandContact(Integer contact,String name);

}
