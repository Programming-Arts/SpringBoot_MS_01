package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sit.entity.RegistrationDetails;
import com.sit.service.RegistrationService;
@RequestMapping("/mvc")
@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	// 1. load registration page with empty information
	@RequestMapping("/loadRegForm")
	public ModelAndView loadRegForm() {
		ModelAndView mav = new ModelAndView();
		// set page name
		mav.setViewName("RegForm");
		// set data
		RegistrationDetails registrationDetails = new RegistrationDetails();
		registrationDetails.setContact(32);
		mav.addObject("regDetails", registrationDetails);
		return mav;
	}

	@RequestMapping("/save")
	public ModelAndView saveRegistrationDetails(@ModelAttribute RegistrationDetails details) {
		System.out.println("Details comming from UI" + details);
		// save the details
		RegistrationDetails savedDetails = service.saveRegistratinoDetails(details);
		System.out.println("Saved details:::" + savedDetails);

		String name = savedDetails.getPersonName();

		ModelAndView mav = new ModelAndView();
		// set page name
		mav.setViewName("Response");
		// set data
		mav.addObject("nameOfPerson", name);
		mav.addObject("regDetails", savedDetails);
		return mav;
	}

	public RegistrationDetails updateRegistratinoDetails() {
		return null;
	}

	public void deleteRegistratinoDetailsByID(Integer id) {
		service.deleteRegistratinoDetailsByID(id);
	}

	public List<RegistrationDetails> getAllDetails() {
		return service.getAllDetails();
	}
}
