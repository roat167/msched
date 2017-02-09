package edu.mum.swe.msched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.swe.msched.domain.Course;


@Repository
public interface CourseDao extends JpaRepository<Course, Long>{

	Course findByCourseCode(int code);
//	Entry findOneByEntryDate(Date entryDate);
//	List<Entry> findByName(String name);

	List<Course> findByCourseName(String name);

}
