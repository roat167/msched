package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.FacultyDao;
import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.service.FacultyService;

@Service
public class FacultyServiceImpl implements FacultyService{
	
	@Autowired
	private FacultyDao facultyDao;

	@Override
	public Faculty findFacultyById(long id) {
		// TODO Auto-generated method stub
		return facultyDao.findOne(id);
	}
	
	@Override
	public Faculty findFacultyByUserName(String username){
		return facultyDao.findFacultyByUsername(username);
	}
	
	@Override
	public List<Faculty> findFacultyByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> findFacultyByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Faculty> getAllFacultys() {
		// TODO Auto-generated method stub
		return facultyDao.findAll();
	}

	@Override
	public void saveFaculty(Faculty faculty) {
		// TODO Auto-generated method stub
		facultyDao.saveAndFlush(faculty);
	}

	@Override
	public void updateFaculty(Long id, Faculty faculty) {
		// TODO Auto-generated method stub
		facultyDao.save(faculty);
	}

	@Override
	public void deleteFaculty(Long id) {
		// TODO Auto-generated method stub
		facultyDao.delete(id);
	}

}
