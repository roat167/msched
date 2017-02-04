package edu.mum.swe.msched.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.BlockService;
import edu.mum.swe.msched.service.StudentService;

@Controller
@SessionAttributes("student")
public class CourseRegistrationController extends GenericController {
	private final static String ATTRIBUTE = "student";
	private final static String VIEW_FORM = "student/enrollSectionForm";
	
	@Autowired
	private StudentService studentService;
	@Autowired
	private BlockService blockService;
	
	
	@RequestMapping(value="/student/enrollCourse", method=RequestMethod.GET) 
	public String showForm(Model model) {		
		Student student = studentService.findStudentByUsername(GenericController.getCurrentUsername());
		if (student == null) student = new Student();
		model.addAttribute(ATTRIBUTE, student);
		
		if (student.getEntry() == null ) {
			setMessage(model, "Student is not belong to any Entry!");
			return getView(model, VIEW_FORM);
		}	
		
		List<Block> blocks = blockService.findAllByEntry(student.getEntry());
		model.addAttribute("blockList", blocks);
		return getView(model, VIEW_FORM);
	}
	
	@RequestMapping(value="/student/enrollCourse", method=RequestMethod.POST) 
	public String showForm(@ModelAttribute(ATTRIBUTE) Student student, Model model) {
		System.out.println(student.getSections());
		List<Block> blocks = blockService.findAllByEntry(student.getEntry());
		model.addAttribute("blockList", blocks);
		return getView(model, VIEW_FORM);
	}
}
