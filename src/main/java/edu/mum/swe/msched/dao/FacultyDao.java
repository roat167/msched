package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.Faculty;

import java.util.List;

public interface FacultyDao extends JpaRepository<Faculty, Long>{

    List<Faculty> findByPreferedBlocks(int blockNo);
}
