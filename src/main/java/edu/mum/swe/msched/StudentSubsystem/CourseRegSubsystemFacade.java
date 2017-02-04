package edu.mum.swe.msched.StudentSubsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.StudentService;

/**
 * 
 * @author kloem
 *
 */
@Service
public class CourseRegSubsystemFacade implements ICourseRegSubSystem {
	 @Autowired
	 StudentService studentService;	

	@Override
	public Student findStudent(Long studentId) {		
		return studentService.findStudentById(studentId);
	}

	@Override
	public void enrollSection(Student student, Section section) {
		// TODO Auto-generated method stub		
	}
}
