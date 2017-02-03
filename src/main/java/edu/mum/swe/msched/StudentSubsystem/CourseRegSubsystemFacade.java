package edu.mum.swe.msched.StudentSubsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.BlockService;
import edu.mum.swe.msched.service.CourseService;
import edu.mum.swe.msched.service.EntryService;
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
	 @Autowired
	 BlockService blockService;
	 @Autowired
	 EntryService entryService;
	 @Autowired
	 CourseService courseService;

	@Override
	public Student findStudent(Long studentId) {		
		return studentService.findStudentById(studentId);
	}

	@Override
	public Entry getEntry(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Block> getBlocks(Entry entry) {
		//TODO return blockService.findByEntry(entry);
		return null;
	}

	@Override
	public Section getSection(Long sectionId) {		
		//TODO return sectionService.findOne(sectionId);
		return null;
	}

	@Override
	public List<Section> getAvailableSections(Block block) {
		//TODO return sectionService.findSections(block)
		return null;
	}

	@Override
	public Course getCourse(Section section) {
		//TODO return sectionService.findCourses(block)
		return null;
	}

	@Override
	public Course getPrerequisite(Course course) {
		//return courseService.findPreReqiusite(course);
		return null;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentService.saveStudent(student);
	}

	@Override
	public Section saveSection(Section section) {
		//TODO sectionService.saveSection()
		return null;
	}

}
