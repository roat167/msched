package edu.mum.swe.msched.service;

import java.util.List;

import edu.mum.swe.msched.domain.Account;

public interface AccountService {
	Account findByUsername(String username);
	List<Account> getAllUsers();
	void saveUser(Account account);
	Account findUserById(Long id);
	void save(Account account);
	void remove(Long id);
	Account getCurrentUser();
}
