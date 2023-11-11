package com.sit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sit.PersonDetails;

//it will make normal java class as Controller layer class
//to handle the req , process it and send back response to UI
@Controller

public class LoginController {

	// load login form without data

	@RequestMapping("/loadForm")
	public ModelAndView loadLoginForm() {
		ModelAndView modelAndView = new ModelAndView();
		// set logical view name to show the page
		PersonDetails person = new PersonDetails();
		modelAndView.setViewName("LoginForm");
		modelAndView.addObject("person", person);
		return modelAndView;
	}


	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute PersonDetails details) {
		System.out.println("Data from UI: ");

		System.out.println(details);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Response");
		modelAndView.addObject("nameOfPerson", details.getPersonName());
		return modelAndView;
	}

}
