package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.StudentDao;
import edu.mum.swe.msched.domain.Student;
import edu.mum.swe.msched.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student findStudentById(Long id) {
		return studentDao.findOne(id);
	}

	@Override
	public List<Student> findStudentByFirstName(String firstName) {
		return studentDao.findStudentByFirstName(firstName);
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) {
		return studentDao.findStudentByLastName(lastName);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentDao.saveAndFlush(student);
	}

	@Override
	public void updateStudent(Long id, Student student) {
		studentDao.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentDao.delete(id);
		
	}

	@Override
	public Student findStudentByUsername(String username) {
		return studentDao.findStudentByUsername(username);	
	}

}
