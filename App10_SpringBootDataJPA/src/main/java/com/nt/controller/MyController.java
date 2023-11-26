package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nt.entity.Person;
import com.nt.service.PersonService;

@Controller // controller layer class
public class MyController {
//	http://localhost:7090/demo

	@Autowired
	private PersonService service;

//	@RequestMapping("/dashboard")
//	public String loadDashBoard() {
//		return "Dashboard";
//	}

	@RequestMapping("/loadForm")
	public ModelAndView loadApplicationFormPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ApplicationForm");
		Person person = new Person();
		modelAndView.addObject("personDetails", person);
		return modelAndView;
	}

	/**
	 * used to load info from creation form page / UI
	 * 
	 * @param personDetailsFromUI
	 * @return ModelAndView : used to return data from backend to UI
	 */
	@RequestMapping(value="/loadInfo",method = RequestMethod.POST)
	public ModelAndView savePersonDetails(@ModelAttribute("personDetails") Person personDetailsFromUI) {
		System.out.println("Info from UI:" + personDetailsFromUI);
		String messageFromService = service.savePersonDetails(personDetailsFromUI);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("List");
		Person personDetails = new Person();
		List<Person> personList = service.getPersonListFromDB();
		modelAndView.addObject("persons", personList);
//		modelAndView.addObject("messageFromService", messageFromService);
		return modelAndView;
	}

	/**
	 * Used to load update form page along with person info
	 * 
	 * @param personDetailsFromUI
	 * @return
	 */
	@RequestMapping(value = "/loadUpdateInfo",method = RequestMethod.POST)
	public ModelAndView loadUpdateInfo(@ModelAttribute("personDetails") Person personDetailsFromUI) {
		System.out.println("Info from UI:" + personDetailsFromUI);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateForm");
		Person person = new Person();
		person.setAddress("Kolhapur");
		person.setPersonName("Yash");
		modelAndView.addObject("personDetails", person);
		return modelAndView;
	}

	/**
	 * Used to load information of all persons
	 */
	@RequestMapping("/showList")
	public ModelAndView loadPersonList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("List");
		List<Person> list = service.getPersonListFromDB();
		modelAndView.addObject("persons", list);
		return modelAndView;
	}

//	template Variable + url params/path parameter
//http://localhost:7079/getPersonById/23

	/**
	 * used to fetch details based on id and show them in updateForm
	 * 
	 * @param id
	 * @return
	 */
//	http://localhost:7079/getPersonById/23
	@RequestMapping("/getPersonById/{path_ID}")
	public ModelAndView getPersonDetailsById(@PathVariable("path_ID") int id) {
		System.out.println("PersonId=" + id);
		Person personDetailsBasedOnPersonId = service.getPersonDetailsBasedOnPersonId(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateForm");
		modelAndView.addObject("personDetails", personDetailsBasedOnPersonId);
		return modelAndView;
	}

	/**
	 * this method is used to get updated info from UI and save to DB
	 */

//	http://localhost:7079/updateInfo
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updatePersonDetails(@ModelAttribute("personDetails") Person updatedPerson) {
		System.out.println("updated details comming from UI: " + updatedPerson);
		String messageservice = service.updateaPersonDetails(updatedPerson);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("List");
		modelAndView.addObject("personDetails", updatedPerson);
		return "redirect:showList";
	}
	
	
	@RequestMapping(value = "/deleteById", method = RequestMethod.GET)
	public String deletePersonDetails(@RequestParam("perID")int id) {
		service.deletePersonDetailsBasedOnID(id);
		return "redirect:showList";
	}

}
