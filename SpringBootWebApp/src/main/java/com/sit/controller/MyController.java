package com.sit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sit.Employee;

@Controller
public class MyController {

//	@RequestMapping("/get")
//	public String get() {
//		return "Page2";
//	}

	@RequestMapping("/get")
	public ModelAndView showPrimitiveData() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("Name", "Ankur");
		modelAndView.addObject("Age", 23);
		modelAndView.addObject("married", false);
		modelAndView.addObject("empDetails", new Employee(12, "Puja"));

		modelAndView.setViewName("Page2");
		return modelAndView;
	}
}
