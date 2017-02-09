package edu.mum.swe.msched.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.service.BlockService;
import edu.mum.swe.msched.service.CourseService;
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
	BlockService blockService;
	@Autowired
	CourseService courseService;
	@Autowired
	FacultyService facultyService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getAllSections(@ModelAttribute(MODEL_ATTRIBUTE) Section section, Model model) {
		model.addAttribute("sectionList", sectionService.getAllSections());
		return getView(model, VIEW_LIST);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String sectionForm(@ModelAttribute(MODEL_ATTRIBUTE) Section section, Model model) {
		model.addAttribute("blockList", blockService.getAllBlocks());
		model.addAttribute("courseList", courseService.getAllCourses());
		model.addAttribute("facultyList", facultyService.getAllFacultys());
		return getView(model, VIEW_FORM);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addOrUpdateSection(@ModelAttribute(MODEL_ATTRIBUTE) @Valid Section section, BindingResult result, Model model) {
		
		model.addAttribute("blockList", blockService.getAllBlocks());
		model.addAttribute("courseList", courseService.getAllCourses());
		model.addAttribute("facultyList", facultyService.getAllFacultys());

		
		if (result.hasErrors()) {
			return getView(model, VIEW_FORM);
		}
		
		if (section.getSectionId() != null) {
			sectionService.saveSection(section);
		} else {
			sectionService.updateSection(section);
		}
		model.addAttribute(MODEL_ATTRIBUTE, section);
		setMessage(model, "Section is saved successfully!");
		return "redirect:/section/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String loadSectionToUpdate(@RequestParam long id, Model model) {
		Section section = sectionService.findSectionById(id);
		model.addAttribute(MODEL_ATTRIBUTE, section);
		model.addAttribute("blockList", blockService.getAllBlocks());
		model.addAttribute("courseList", courseService.getAllCourses());
		model.addAttribute("facultyList", facultyService.getAllFacultys());
		return getView(model, VIEW_FORM);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteSection(@RequestParam long id, Model model) {
		sectionService.deleteSection(id);
		return "redirect:/section/list";
	}
}
