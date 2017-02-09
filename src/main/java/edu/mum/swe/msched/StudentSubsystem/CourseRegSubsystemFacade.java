package edu.mum.swe.msched.StudentSubsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Section;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.exception.NoAvailableSeatException;
import edu.mum.swe.msched.exception.PrerequisiteNotSatisfyException;
import edu.mum.swe.msched.service.SectionService;
import edu.mum.swe.msched.service.StudentService;
import edu.mum.swe.msched.util.DescriptionHelper;

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
	public boolean enrollSection(Student student, Section section) {

		if (!sectionAvailable(section))
			throw new NoAvailableSeatException("No Seat Available for " + DescriptionHelper.shortDescription(section));
		if (!checkPrerequisite(student.getSections(), section)) {
			throw new PrerequisiteNotSatisfyException(DescriptionHelper.preRequisiteCourseName(section.getCourse())
					+ " is required before taking " + section.getCourse().getCourseName());
		}
		section.setTotalStudent(section.getTotalStudent() + 1);
		student.getSections().add(section);
		studentService.saveStudent(student);
		sectionService.saveSection(section);
		return true;
	}

	@Override
	public boolean enrollSections(Student student, List<Section> sections) {
		return validateEnrollSections(student, sections);
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
	private boolean validateEnrollSections(Student student, List<Section> enrolledSections) {
		List<Section> tmpSections = enrolledSections;
		for (Section section : tmpSections) {
			if (!sectionAvailable(section)) 
				throw new NoAvailableSeatException(
						"No Seat Available for " + DescriptionHelper.shortDescription(section));
			
			if (!checkPrerequisite(enrolledSections, section)) 
				throw new PrerequisiteNotSatisfyException(DescriptionHelper.preRequisiteCourseName(section.getCourse())
						+ " is required before taking " + section.getCourse().getCourseName());
						
		}
		//update Section
		for (Section section : enrolledSections) { 
			section.setTotalStudent(section.getTotalStudent() + 1);
			sectionService.saveSection(section);
		}		
		studentService.saveStudent(student);
		return true;
		
	}

	/** Check available seat for the section **/
	private boolean sectionAvailable(Section section) {
		return section.getMaxCapacity() - section.getTotalStudent() > 0;
	}
}
