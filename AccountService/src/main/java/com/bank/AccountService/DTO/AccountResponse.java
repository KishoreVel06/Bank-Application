package com.bank.AccountService.DTO;

import java.time.LocalDateTime;


public class AccountResponse {
	
	private long accountId;
	private Long userId;
	private String accountNumber;
	private String accountType;
	private Double balance;
	private String status;

	private LocalDateTime createdAcc;
	
	public LocalDateTime getCreatedAcc() {
		return createdAcc;
	}
	public void setCreatedAcc(LocalDateTime createdAcc) {
		this.createdAcc = createdAcc;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
