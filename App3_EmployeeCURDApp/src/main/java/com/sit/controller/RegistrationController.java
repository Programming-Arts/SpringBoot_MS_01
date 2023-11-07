package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sit.entity.RegistrationDetails;
import com.sit.service.RegistrationService;

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
		mav.addObject("regDetails", registrationDetails);
		return mav;
	}

	@RequestMapping("/save")
	public String saveRegistrationDetails(@ModelAttribute RegistrationDetails details) {
		System.out.println("Details comming from UI" + details);
		// save the details
		RegistrationDetails savedDetails = service.saveRegistratinoDetails(details);
		System.out.println("Saved details:::" + savedDetails);

		String name = savedDetails.getPersonName();

//		ModelAndView mav = new ModelAndView();
//		// set page name
//		mav.setViewName("List");
//		// set data
//		mav.addObject("nameOfPerson", name);
//		mav.addObject("regDetails", savedDetails);

		return "redirect:/showTable";
	}

	@RequestMapping("/showTable")
	public ModelAndView loadTable() {
		ModelAndView mav = new ModelAndView();
		// calling service layer method to get all records fromDB
		List<RegistrationDetails> list = service.getAllDetails();
		// add data to mav object
		mav.addObject("detailsList", list);
		mav.setViewName("List");
		return mav;
	}

//	http://localhost:7090/getDetails/12
	@RequestMapping("/getDetails/{id}")
	public ModelAndView getDetailsByID(@PathVariable("id") int personID) {
		ModelAndView mav = new ModelAndView();
		// set page name
		mav.setViewName("UpdateForm");
		// add data to mav
		RegistrationDetails details = service.getDetailsById(personID);
		mav.addObject("regDetails", details);
		return mav;
	}

	@RequestMapping("/update")
	public String updateRegistrationDetails(@ModelAttribute RegistrationDetails details) {
		System.out.println("Data from UI " + details);
		// get all old details based on id coming from UI
		int id = details.getPersonID();

		RegistrationDetails oldDetails = service.getDetailsById(id);
		// set all new values to old obj coming from UI
		oldDetails.setContact(details.getContact());
		oldDetails.setEmail(details.getEmail());
		oldDetails.setPersonAge(details.getPersonAge());
		oldDetails.setPersonName(details.getPersonName());

		// save this details
		service.saveRegistratinoDetails(oldDetails);
		return "redirect:/showTable";
	}

	@RequestMapping("/deleteById/{id}")
	public String deleteRecordsById(@PathVariable("id") String id) {
		System.out.println("ID: " + id);
		//convert id from String to Integer
		int personId=Integer.valueOf(id);
		service.deleteRegistratinoDetailsByID(personId);
		return "redirect:/showTable";
	}

}
