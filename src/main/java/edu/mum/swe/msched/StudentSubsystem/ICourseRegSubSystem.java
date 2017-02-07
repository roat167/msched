package edu.mum.swe.msched.StudentSubsystem;

import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;

/**
 * 
 * @author kloem
 *
 */
		
public interface ICourseRegSubSystem {
	Student findStudent(Long studentId);
	String enrollSection(Student student, Section section);
}
