package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.repo.PersonRepo;

//layer is used for business logic
@Service
public class PersonService {

	// autowire repo in service
	@Autowired
	private PersonRepo repo;

	// save person details
	public String savePersonDetails(Person personDetails) {
		String message = "";
		System.out.println("inside service layer");
		Person savedPerson = repo.save(personDetails);
		message = "Person details saved with id:" + savedPerson.getPersonId();
		System.out.println(message);
		return message;
	}

	// delete person details based on ID
	// show all person details
	public List<Person> getPersonListFromDB() {
		List<Person> personList = repo.findAll();
		return personList;

	}

	// get person details based on personId
	public Person getPersonDetailsBasedOnPersonId(Integer id) {
		Optional<Person> optionalPersonDetails = repo.findById(id);
		Person actualPersonDetails = optionalPersonDetails.get();
		return actualPersonDetails;
	}

	// update person details based on ID
	public String updateaPersonDetails(Person updatedPersonDetails) {
           String message="";
		System.out.println("inside service : " + updatedPersonDetails);

		// get id from updatedPersonDetails
		int id = updatedPersonDetails.getPersonId();
		// get complete record from DB based on id
		Person existedPerson = getPersonDetailsBasedOnPersonId(id);
		// update all properties except id
		existedPerson.setAddress(updatedPersonDetails.getAddress());
		existedPerson.setAge(updatedPersonDetails.getAge());
		existedPerson.setContact(updatedPersonDetails.getContact());
		existedPerson.setGender(updatedPersonDetails.getGender());
		existedPerson.setPersonName(updatedPersonDetails.getPersonName());
		savePersonDetails(existedPerson);
		System.out.println("Details updated successfully");
		message="Details updated successfully";		
		return message;
	}
	
	public void deletePersonDetailsBasedOnID(int id) {
		repo.deleteById(id);
	}
}
