package edu.mum.swe.msched.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.swe.msched.domain.Course;
@Service
@Transactional
public interface CourseService {
	List<Course> getAllCourses();

	List<Course> findByCourseName(String name);

	public void updateCourse(Course course);

	public Course findByCourseId(Long id);

	public Course saveCourse(Course course);

	public void deleteCourse(Long id);

	Course findByCourseCode(int code);
}
