package edu.mum.swe.msched.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.StudentService;
import edu.mum.swe.msched.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("/student")
public class StudentController extends GenericController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> getAllStudentList() {		
		return studentService.getAllStudents();
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public void updateStudent(@PathVariable long id, @RequestBody Student student) {
		studentService.updateStudent(id, student);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
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
