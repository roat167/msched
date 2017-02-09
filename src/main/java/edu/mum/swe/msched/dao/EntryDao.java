package edu.mum.swe.msched.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.swe.msched.domain.Entry;
import edu.mum.swe.msched.domain.Faculty;

@Repository
public interface EntryDao extends JpaRepository<Entry, Long> {	
	Entry findOneByEntryDate(Date entryDate);

    @Query("select distinct f from Faculty f inner join f.user u where u.username=:username")
    Faculty findFacultyByUsername(@Param(value="username") String username);

}
