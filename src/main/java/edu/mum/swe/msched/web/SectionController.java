package edu.mum.swe.msched.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.FacultyService;
import edu.mum.swe.msched.service.SectionService;

@Controller
@RequestMapping(value = "/section")
public class SectionController extends GenericController {

	private final String MODEL_ATTRIBUTE = "section";
	private final String VIEW_FORM = "section/sectionForm";
	private final String VIEW_LIST = "section/sectionList";
	
	@Autowired
	SectionService sectionService;
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAllSections(@ModelAttribute(MODEL_ATTRIBUTE) Section section, Model model) {
		model.addAttribute("sectionList", sectionService.getAllSections());
		return getView(model, VIEW_LIST);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String sectionForm(@ModelAttribute(MODEL_ATTRIBUTE) Section section, Model model) {
		model.addAttribute("facultyList", facultyService.getAllFacultys());
		return getView(model, VIEW_FORM);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdateSection(@ModelAttribute(MODEL_ATTRIBUTE) Section section, Model model) {
		if (section.getSectionId() != null) {
			sectionService.saveSection(section);
		} else {
			sectionService.updateSection(section);
		}
		model.addAttribute(MODEL_ATTRIBUTE, section);
		setMessage(model, "Section is saved successfully!");
		return "redirect:/section/list";
	}
}
