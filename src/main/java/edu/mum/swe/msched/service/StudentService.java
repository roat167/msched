package edu.mum.swe.msched.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Student;

public interface StudentService {
	Student findStudentById(Long id);
	List<Student> findStudentByFirstName(String firstName);
	List<Student> findStudentByLastName(String lastName);
	List<Student> getAllStudents();
	void saveStudent(Student student);
	void updateStudent(Long id, Student student);
	void deleteStudent(Long id);
}
