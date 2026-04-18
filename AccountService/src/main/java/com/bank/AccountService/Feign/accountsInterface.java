package com.bank.AccountService.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.AccountService.DTO.UserDTO;

@FeignClient("USER-SERVICE")
public interface accountsInterface {
	
    @GetMapping("/user/{id}")
	public UserDTO getUserById(@PathVariable("id") Long id);
	
}
