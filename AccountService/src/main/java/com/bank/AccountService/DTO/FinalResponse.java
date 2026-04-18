package com.bank.AccountService.DTO;

public class FinalResponse {
	
	private String status;
	private String message;
	private AccountResponse data;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public AccountResponse getData() {
		return data;
	}
	public void setData(AccountResponse data) {
		this.data = data;
	}

}
