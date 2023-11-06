package com.sit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sit.entity.RegistrationDetails;
import com.sit.service.RegistrationService;

@RequestMapping("/mvc")
@Controller
public class RegistrationWebController {

	@Autowired
	private RegistrationService service;

	// 1. load registration page with empty information
	@RequestMapping("/loadRegForm")
	public ModelAndView loadRegForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("RegForm");
		RegistrationDetails registrationDetails = new RegistrationDetails();
		mav.addObject("regDetails", registrationDetails);
		return mav;
	}

	@RequestMapping("/save")
	public String saveRegistrationDetails(@ModelAttribute RegistrationDetails details) {
		RegistrationDetails savedDetails = service.saveRegistratinoDetails(details);
		String name = savedDetails.getPersonName();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Response");
		mav.addObject("nameOfPerson", name);
		mav.addObject("regDetails", savedDetails);
		return "redirect:pagination/0/10";
	}

	@RequestMapping("/showTable")
	public ModelAndView showTable() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.getAllDetails());
		mav.addObject("naam", "Naaja");
		mav.setViewName("Records");
		return mav;
	}

	public RegistrationDetails updateRegistratinoDetails() {
		return null;
	}

	public void deleteRegistratinoDetailsByID(Integer id) {
		service.deleteRegistratinoDetailsByID(id);
	}

	@GetMapping("/pagination/{pageNo}/{size}")
	public ModelAndView getByPagination(@PathVariable("pageNo") Integer pageNo, @PathVariable("size") Integer size) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", service.getByPagination(pageNo, size));
		mav.addObject("naam", "Naaja");
		mav.setViewName("Records");
		return mav;
	}
}
