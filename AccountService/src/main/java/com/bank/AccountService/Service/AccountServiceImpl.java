package com.bank.AccountService.Service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bank.AccountService.DTO.AccountResponse;
import com.bank.AccountService.DTO.FinalResponse;
import com.bank.AccountService.DTO.UserDTO;
import com.bank.AccountService.Entity.Account;
import com.bank.AccountService.Feign.accountsInterface;
import com.bank.AccountService.Repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	accountsInterface AccountsInterface;
	
	@Autowired
	AccountRepository accountRepository;
	

	@Override
	public ResponseEntity<FinalResponse> createAccount(Long userId, String accountType) {

		UserDTO existingUser = AccountsInterface.getUserById(userId);
		
		Account userAccountType = accountRepository.findByUserIdAndAccountType(userId,accountType);
		
		if(existingUser == null)
		{
			FinalResponse res = new FinalResponse();
			res.setMessage("User not found with this ID");
			res.setStatus("Failed");
			res.setData(null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		
		if(userAccountType != null)
		{
			FinalResponse res = new FinalResponse();
			res.setMessage("Same Account Type already exist for this User");
			res.setStatus("Failed");
			res.setData(null);
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
		}
		
		Account account = new Account();
	    account.setUserId(userId);
	    account.setAccountType(accountType.toUpperCase());
	    account.setAccountNumber(generateAccountNumber());  
	    account.setBalance(0.0);
	    account.setStatus("ACTIVE");
	    account.setCreatedAcc(LocalDateTime.now());
	    
	    Account savedAccount = accountRepository.save(account);
	 
	    AccountResponse data = new AccountResponse();
	    data.setAccountId(savedAccount.getAccountId());
	    data.setAccountNumber(savedAccount.getAccountNumber());
	    data.setAccountType(savedAccount.getAccountType());
	    data.setBalance(savedAccount.getBalance());
	    data.setStatus(savedAccount.getStatus());
	    data.setUserId(savedAccount.getUserId());
	    data.setCreatedAcc(savedAccount.getCreatedAcc());
	 
	    FinalResponse response = new FinalResponse();
	    response.setStatus("SUCCESS");
	    response.setMessage("Account created successfully");
	    response.setData(data);
	 
	    return ResponseEntity.status(HttpStatus.CREATED).body(response);
		
	}
	
	private String generateAccountNumber() {
	    int random = (int) (Math.random() * 900000) + 100000; 
	    return "ACC" + random;
	}
	
	

}
