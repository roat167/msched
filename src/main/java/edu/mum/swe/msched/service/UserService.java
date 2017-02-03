package edu.mum.swe.msched.service;

import java.util.List;

import edu.mum.swe.msched.domain.User;

public interface UserService {
	User findByUsername(String username);
	List<User> getAllUsers();
	void saveUser(User user);
	User findUserById(Long id);
	void save(User user);
	void remove(Long id);
	User getCurrentUser();
}
