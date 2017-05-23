package edu.mum.swe.msched.service.impl;

import java.util.List;

import edu.mum.swe.msched.dao.AccountDao;
import edu.mum.swe.msched.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.swe.msched.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	AccountDao userDao;

	@Override
	public void remove(Long id) {
		userDao.delete(id);
	}

	@Override
	public void save(Account account) {
		userDao.save(account);
	}

	@Override
	public Account findUserById(Long id) {
		return userDao.findOne(id);
	}

	@Override
	public void saveUser(Account account) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(hashedPassword);
		userDao.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public List<Account> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public Account getCurrentUser() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();		
		return userDao.findByUsername(auth.getName());
	}

}
