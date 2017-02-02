package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Long>{
	
}
