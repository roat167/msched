package edu.mum.swe.msched.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mum.swe.msched.domain.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
