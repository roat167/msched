package edu.mum.swe.msched.StudentSubsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.SectionService;
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
	SectionService sectionService;

	@Override
	public Student findStudent(Long studentId) {
		return studentService.findStudentById(studentId);
	}

	@Override
	public String enrollSection(Student student, Section section) {		
		if (!sectionAvailable(section))
			return "No Seat Available";
		if (!checkPrerequisite(student.getSections(), section))
			return "PreRequisite course is not statisfied";

		section.setTotalStudent(section.getTotalStudent() + 1);
		student.getSections().add(section);
		studentService.saveStudent(student);
		sectionService.saveSection(section);
		return "Sucessfully Saved";
	}

	/**
	 * check if the section has preRequisite course then check if student have
	 * enrolled prerequisite course for that section in former block
	 * 
	 * @param enrolledSections
	 * @param section
	 * @return boolean
	 */
	private boolean checkPrerequisite(List<Section> enrolledSections, Section section) {
		Course preReq = section.getCourse().getPreReqiusite();
		if (preReq == null)
			return true;

		for (Section s : enrolledSections) {
			if (s.getCourse().getId().equals(preReq.getId())
					&& s.getBlock().getStartDate().before(section.getBlock().getStartDate())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check if the section has preRequisite course then check if student have
	 * enrolled prerequisite course for that section in former block
	 * 
	 * @param enrolledSections
	 * @param section
	 * @return boolean
	 */
	private String validateEnrollSections(List<Section> enrolledSections) {
		List<Section> tmpSections = enrolledSections;		
		for (Section section : tmpSections) {
			if (!sectionAvailable(section))
				return "No Seat Available";
			if (!checkPrerequisite(enrolledSections, section))
				return "PreRequisite course is not statisfied";
			Course preReq = section.getCourse().getPreReqiusite();	
			if (preReq == null)
				continue;
			for (Section s : enrolledSections) {
				if (!(s.getCourse().getId().equals(preReq.getId())
						&& s.getBlock().getStartDate()
						.before(section.getBlock().getStartDate()))) {
					return preReq.getCourseName() + " is required before taking " + section.getCourse().getCourseName();
				}
			}
		}
		return "";
	}
	
	private boolean sectionAvailable(Section section) {
		return section.getMaxCapacity() - section.getTotalStudent() > 0;
	}
}
