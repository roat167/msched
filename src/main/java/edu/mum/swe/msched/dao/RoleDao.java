package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.Role;

public interface RoleDao extends JpaRepository<Role, Long> {
	//@Query("from Role r where r.name:name ")
	//List<String> findByNam(String name);

}
