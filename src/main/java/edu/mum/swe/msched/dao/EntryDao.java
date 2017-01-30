package edu.mum.swe.msched.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.swe.msched.domain.Entry;

@Repository
public interface EntryDao extends JpaRepository<Entry, Long> {	
	Entry findOneByEntryDate(Date entryDate);
	List<Entry> findByName(String name);
}
