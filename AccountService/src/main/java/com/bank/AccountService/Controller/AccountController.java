package com.bank.AccountService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bank.AccountService.DTO.AccountResponse;
import com.bank.AccountService.DTO.FinalResponse;
import com.bank.AccountService.DTO.UserDTO;
import com.bank.AccountService.Service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/createAccount")
	public ResponseEntity<FinalResponse> createAccount(@RequestBody UserDTO request)
	{
		return accountService.createAccount(request.getUserId(),request.getAccountType());
	}
	
	

}
