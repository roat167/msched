package edu.mum.swe.msched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

	List<Student> findStudentByFirstName(String firstName);
	List<Student> findStudentByLastName(String lastName);
	
}
