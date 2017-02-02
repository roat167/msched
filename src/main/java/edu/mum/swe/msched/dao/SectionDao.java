package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.Section;

public interface SectionDao extends JpaRepository<Section, Long> {

}
