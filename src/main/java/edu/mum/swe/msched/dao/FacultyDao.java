package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.swe.msched.domain.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Long>{
	
	@Query("select distinct f from Faculty f inner join f.user u where u.username=:username")
	Faculty findFacultyByUsername(@Param(value="username") String username);
}
