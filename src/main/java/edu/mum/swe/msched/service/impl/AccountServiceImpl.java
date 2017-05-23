package edu.mum.swe.msched.service.impl;

import java.util.List;

import edu.mum.swe.msched.dao.AccountDao;
import edu.mum.swe.msched.domain.Account;
import edu.mum.swe.msched.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	AccountDao accountDao;

	@Override
	public void remove(Long id) {
		accountDao.delete(id);
	}

	@Override
	public void save(Account account) {
		accountDao.save(account);
	}

	@Override
	public Account findUserById(Long id) {
		return accountDao.findOne(id);
	}

	@Override
	public void saveUser(Account account) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(account.getPassword());
		account.setPassword(hashedPassword);
		accountDao.save(account);
	}

	@Override
	public Account findByUsername(String username) {
		return accountDao.findByUsername(username);
	}

	@Override
	public List<Account> getAllUsers() {
		return accountDao.findAll();
	}

	@Override
	public Account getCurrentUser() {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();		
		return accountDao.findByUsername(auth.getName());
	}

}
