package com.bank.AccountService.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bank.AccountService.DTO.FinalResponse;

@Service
public interface AccountService {

	ResponseEntity<FinalResponse> createAccount(Long userId, String accountType);

	ResponseEntity<FinalResponse> changeAccType(Integer accId, String accountType);
	
	
	
}
