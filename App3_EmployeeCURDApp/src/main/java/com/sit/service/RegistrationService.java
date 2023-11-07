package com.sit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sit.entity.RegistrationDetails;
import com.sit.repo.RegistrationRepo;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepo repo;

	public RegistrationDetails saveRegistratinoDetails(RegistrationDetails details) {
		return repo.save(details);
	}

	public RegistrationDetails updateRegistratinoDetails() {
		return null;
	}

	public void deleteRegistratinoDetailsByID(Integer id) {
		repo.deleteById(id);
	}

	public List<RegistrationDetails> getAllDetails() {
		List<RegistrationDetails> list = repo.findAll();
		return list;
	}

	public RegistrationDetails getDetailsById(int id) {
		Optional<RegistrationDetails> optionaDetails = repo.findById(id);
		return optionaDetails.get();
	}
}
