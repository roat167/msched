package edu.mum.swe.msched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.enumeration.PREFERED_BLOCK;

public interface FacultyDao extends JpaRepository<Faculty, Long>{

	List<Faculty> findByPreferedBlocks(PREFERED_BLOCK preferedBlock);
	
	@Query("select distinct f from Faculty f inner join f.account u where u.username=:username")
	Faculty findFacultyByUsername(@Param(value="username") String username);

}
