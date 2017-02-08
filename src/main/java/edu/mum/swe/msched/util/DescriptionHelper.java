package edu.mum.swe.msched.util;

import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.domain.Section;

public class DescriptionHelper {
	public static String shortDescription(Section section) {
		if (section != null && section.getSectionId() != null) {
			return section.getCourse().getCourseName() + " " + section.getBlock().getStartDate() + " Prof."
					+ section.getFaculty().getFullName();
		}
		return "";
	}
	
	public static String preRequisiteCourseName(Course course) {
		if (course != null) 
			return course.getPreReqiusite().getCourseName();
		return "";
	}
}
