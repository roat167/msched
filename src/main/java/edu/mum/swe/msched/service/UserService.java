package edu.mum.swe.msched.service;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.dao.UserDao;
import edu.mum.swe.msched.domain.User;

@Service
@Transactional
public class UserService {
	@Resource
	UserDao userDao;

	public void remove(Long id) {
		userDao.delete(id);
	}

	public void save(User user) {
		userDao.save(user);
	}

	public User findUserById(Long id) {
		return userDao.findOne(id);
	}

	public void saveUser(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		userDao.save(user);
	}

	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	public List<User> getAllUsers() {
		return userDao.findAll();
	}

}
