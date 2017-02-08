package edu.mum.swe.msched.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mum.swe.msched.domain.Faculty;

public interface FacultyService {
	Faculty findFacultyById(long i);
	Faculty findFacultyByUserName(String name);
	List<Faculty> findFacultyByFirstName(String firstName);
	List<Faculty> findFacultyByLastName(String lastName);
	List<Faculty> getAllFacultys();
	void saveFaculty(Faculty faculty);
	void updateFaculty(Long id, Faculty faculty);
	void deleteFaculty(Long id);
	Faculty findFacultyByUserName(String username);
	List<Faculty> findFacultyByPreferedBlock(int BlockNo);
}
