package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.swe.msched.domain.Faculty;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyDao extends JpaRepository<Faculty, Long>{

	List<Faculty> findByPreferedBlocks(int blockNo);
	
	@Query("select distinct f from Faculty f inner join f.user u where u.username=:username")
	Faculty findFacultyByUsername(@Param(value="username") String username);

}
