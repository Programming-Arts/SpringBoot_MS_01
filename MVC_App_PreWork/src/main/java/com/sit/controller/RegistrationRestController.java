package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sit.entity.RegistrationDetails;
import com.sit.service.RegistrationService;

@RequestMapping("/api")
@RestController
public class RegistrationRestController {

	@Autowired
	private RegistrationService service;

	// 1. load registration page with empty information

	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public RegistrationDetails saveRegistrationDetails(@RequestBody RegistrationDetails details) {

		RegistrationDetails savedDetails = service.saveRegistratinoDetails(details);
		return savedDetails;
	}

	@GetMapping("/getAll")
	public List<RegistrationDetails> getAllDetails() {
		return service.getAllDetails();
	}

	@GetMapping("/pagination/{pageNo}/{size}")
	public List<RegistrationDetails> getByPagination(@PathVariable("pageNo") Integer pageNo,
			@PathVariable("size") Integer size) {
		return service.getByPagination(pageNo, size);
	}

	public RegistrationDetails updateRegistratinoDetails(@RequestAttribute RegistrationDetails details) {
		return service.updateRegistratinoDetails();
	}

	@DeleteMapping("/deleteByid/{id}")
	public void deleteRegistratinoDetailsByID(@PathVariable("id") Integer id) {
		service.deleteRegistratinoDetailsByID(id);
	}
}
