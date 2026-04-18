package com.bank.AccountService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.AccountService.Entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

	Account findByUserIdAndAccountType(Long userId, String accountType);
	

}
