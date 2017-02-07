package edu.mum.swe.msched.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.domain.User;
import edu.mum.swe.msched.enumeration.ROLE;
import edu.mum.swe.msched.service.EntryService;
import edu.mum.swe.msched.service.StudentService;
import edu.mum.swe.msched.service.impl.StudentServiceImpl;

@Controller
@RequestMapping(value = "/student")
public class StudentController extends GenericController {

	private static final String MODEL_ATTRIBUTE = "student";
	private static final String VIEW_LIST = "student/studentList";
	private static final String VIEW_FORM = "student/studentForm";

	
	@Autowired
	StudentService studentService;
	@Autowired
	EntryService entryService;
	
	@RequestMapping(value = {"/list", ""}, method = RequestMethod.GET)
	public String getAllStudentList(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return getView(model, VIEW_LIST);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute(MODEL_ATTRIBUTE) Student student, Model model) {
		//studentService.saveStudent(student);
		System.out.println("Add student!!!");
		if (student.getStudentId() == null) {
						
			User user = student.getUser();
			user.setRole(ROLE.STUDENT);
			user.setPassword("password");
			user.setUsername(student.getFirstName().substring(0, 1) + student.getLastName());
			user.setEnabled(true);
			
			studentService.saveStudent(student);
		} else {
			System.out.println("Student -> " + student.toString());
			studentService.updateStudent(student.getStudentId(), student);
		}
		model.addAttribute(MODEL_ATTRIBUTE, student);
		setMessage(model, "Student is saved successfully!");
		return "redirect:/student";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String detailPage(@ModelAttribute(MODEL_ATTRIBUTE) Student student, Model model ) {
		//model.addAttribute("view", VIEW_FORM);
		model.addAttribute("entryList", entryService.getAllEntries());
		return getView(model, VIEW_FORM);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView loadStudentInfo(@RequestParam long id, Model model) {
		System.out.print("Id = " + id);
		Student student = studentService.findStudentById(id);
		model.addAttribute(MODEL_ATTRIBUTE, student);
		model.addAttribute("entryList", entryService.getAllEntries());
		return new ModelAndView(getView(model, VIEW_FORM), "command", student);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam long id, Model model) {
		setMessage(model, "Selected student deleted successfully");
		System.out.println("Delete student with id = " + id);

		studentService.deleteStudent(id);

		model.addAttribute("id", id);
		model.addAttribute("students", studentService.getAllStudents());
		return new ModelAndView(getView(model, VIEW_LIST), "command", new Student());

	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable long id) {
		return studentService.findStudentById(id);
	}
	
	@RequestMapping(value = "/first_name/{firstName}", method = RequestMethod.GET)
	public List<Student> getStudentByFirstName(@PathVariable String firstName) {
		return studentService.findStudentByFirstName(firstName);
	}
	
	@RequestMapping(value = "/last_name/{lastName}", method = RequestMethod.GET)
	public List<Student> getStudentByLastName(String lastName) {
		return studentService.findStudentByLastName(lastName);
	}
}
