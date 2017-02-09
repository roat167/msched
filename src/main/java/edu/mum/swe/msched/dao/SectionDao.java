package edu.mum.swe.msched.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.mum.swe.msched.domain.Block;
import edu.mum.swe.msched.domain.Faculty;
import edu.mum.swe.msched.domain.Section;

public interface SectionDao extends JpaRepository<Section, Long> {

	@Query("select distinct s from Section s where s.block=:block and s.totalStudent < s.maxCapacity")
	List<Section> findAvailableSectionByBlock(@Param(value="block") Block block);
	
	@Query("select distinct s from Section s where s.faculty=:faculty")
	List<Section> findSectionByFacultyId(@Param(value="faculty") Faculty faculty);
	
	@Query("select distinct s from Section s where s.faculty=:faculty and s.block=:block")
	List<Section> findSectionByFacultyAndBlock(@Param(value="faculty") Faculty faculty, @Param(value="block") Block block);
}
