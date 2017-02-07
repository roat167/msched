package edu.mum.swe.msched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.swe.msched.domain.Student;

public interface StudentDao extends JpaRepository<Student, Long> {

	List<Student> findStudentByFirstName(String firstName);
	List<Student> findStudentByLastName(String lastName);
	@Query("select distinct s from Student s inner join s.user u where u.username=:username")
	Student findStudentByUsername(@Param(value="username") String username);
	
}
