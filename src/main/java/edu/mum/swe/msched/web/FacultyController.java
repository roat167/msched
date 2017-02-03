package edu.mum.swe.msched.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.domain.User;
import edu.mum.swe.msched.enumeration.ROLE;
import edu.mum.swe.msched.service.FacultyService;

@Controller
@RequestMapping(value = "/faculty")
public class FacultyController extends GenericController {
	
	private static final String MODEL_ATTRIBUTE = "faculty";
	private static final String VIEW_FORM = "faculty/facultyForm";
	private static final String VIEW_LIST = "faculty/facultyList";

	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getFacultyList(Model model) {
		model.addAttribute("facultyList", facultyService.getAllFacultys());
		return getView(model, VIEW_LIST);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String facultyForm(@ModelAttribute(MODEL_ATTRIBUTE) Faculty faculty, Model model) {
		return getView(model, VIEW_FORM);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdateFaculty(@ModelAttribute(MODEL_ATTRIBUTE) Faculty faculty, Model model) {
		if (faculty.getFacultyId() == null) {
			/**
			 * Since faculty has property user; therefore, every time we register new faculty we need to create 
			 * user as well. 
			 */
			// Set default value to user that attached to faculty
			User user = faculty.getUser();
			user.setRole(ROLE.FACULTY);
			user.setUsername(faculty.getFirstName().substring(0,1) + faculty.getLastName());
			user.setPassword("password");
			user.setEnabled(true);
			//Save faculty into DB
			facultyService.saveFaculty(faculty);
			
		} else {
			// Update faculty into DB
			facultyService.updateFaculty(faculty.getFacultyId(), faculty);
		}
		
		model.addAttribute(MODEL_ATTRIBUTE, faculty);
		setMessage(model, "Faculty is saved successfully!");
		
		return "redirect:/faculty/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String loadFacultyToUpdate(@RequestParam long id, Model model) {
		Faculty faculty = facultyService.findFacultyById(id);
		model.addAttribute(MODEL_ATTRIBUTE, faculty);
		return getView(model, VIEW_FORM);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteFaculty(@RequestParam long id, Model model) {	
		facultyService.deleteFaculty(id);		
		setMessage(model, "Faculty is deleted successfully!");
		
		return getView(model, VIEW_LIST);
	}
}
