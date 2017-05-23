package edu.mum.swe.msched.dao;

import edu.mum.swe.msched.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
	Account findByUsername(String username);
}
