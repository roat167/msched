package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.swe.msched.dao.CourseDao;
import edu.mum.swe.msched.domain.Course;
import edu.mum.swe.msched.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{
	@Autowired
	CourseDao courseDao;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course findByCourseName(String name) {
		// TODO Auto-generated method stub
		List<Course> courses  = courseDao.findByCourseName(name);
		return courses.size() > 0 ? courses.get(0) : null;
	}

	@Override
	public Course findByCourseCode(int code) {
		// TODO Auto-generated method stub
		return courseDao.findByCourseCode(code);
	}

	@Override
	public void updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseDao.save(course);
	}

	@Override
	public Course findByCourseId(Long id) {
		// TODO Auto-generated method stub
		return courseDao.findOne(id);
	}

	@Override
	public Course saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.save(course);
	}

	@Override
	public void deleteCourse(Long id) {
		// TODO Auto-generated method stub
		courseDao.delete(id);
	}

}
