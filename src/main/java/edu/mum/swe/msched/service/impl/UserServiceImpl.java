package edu.mum.swe.msched.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.UserDao;
import edu.mum.swe.msched.domain.User;
import edu.mum.swe.msched.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	public void remove(Long id) {
		userDao.delete(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public User findUserById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public void saveUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		userDao.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
