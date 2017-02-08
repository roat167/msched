package edu.mum.swe.msched.StudentSubsystem;

import java.util.List;

import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;

/**
 * 
 * @author kloem
 *
 */
		
public interface ICourseRegSubSystem {
	Student findStudent(Long studentId);
	boolean enrollSection(Student student, Section section);
	boolean enrollSections(Student student, List<Section> sections);
}
