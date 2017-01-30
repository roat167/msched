package edu.mum.swe.msched.StudentSubsystem;

import java.util.List;

import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;

/**
 * 
 * @author kloem
 *
 */
		
public interface ICourseRegSubSystem {
	Student findStudent(Long studentId);
	Entry getEntry(Student student);
	List<Block> getBlocks(Entry entry);
	Section getSection(Long sectionId);
	List<Section> getAvailableSection(Block block);
	Course getCourse(Section section);
	List<Course> getPrerequisites(Course course);
	void enrollSection(Student student, Section section);
	Student saveStudent(Student student);
	Section saveSection(Section section);
}
