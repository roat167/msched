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
		// TODO Auto-generated method stub
		return studentDao.findOne(id);
	}

	@Override
	public List<Student> findStudentByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByFirstName(firstName);
	}

	@Override
	public List<Student> findStudentByLastName(String lastName) {
		// TODO Auto-generated method stub
		return studentDao.findStudentByLastName(lastName);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.findAll();
	}

	@Override
	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		studentDao.saveAndFlush(student);
	}

	@Override
	public void updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		studentDao.delete(id);
		
	}

}
