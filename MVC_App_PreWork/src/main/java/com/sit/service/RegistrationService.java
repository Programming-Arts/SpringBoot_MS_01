package com.sit.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		List<RegistrationDetails> list = (List<RegistrationDetails>) repo.findAll();
		return list;
	}

	// ---------advance concepts
	public List<RegistrationDetails> getByPagination(int pageNo, int size) {
		Page<RegistrationDetails> pages = null;
		try {

			List<RegistrationDetails> list = new LinkedList();
			PageRequest pageable = PageRequest.of(pageNo, size, Sort.by("personID"));
			pages = repo.findAll(pageable);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return pages.getContent();

	}

}
