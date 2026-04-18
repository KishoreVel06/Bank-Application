package com.userService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.userService.Entity.UserModel;
import com.userService.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository repo;
	
	@Autowired
	private  PasswordEncoder security;

	public UserModel registerUser(UserModel user) {
	repo.findByEmail(user.getEmail()).ifPresent(u->{
		throw new RuntimeException("Email alerady Registered");
	});
	
		user.setPassword(security.encode(user.getPassword()));
		
	return repo.save(user);

 }
	
	
	public UserModel getById(Long Id) {
		return repo.findById(Id).orElseThrow(()-> new RuntimeException("User Not Found"));
	}
	
	public List<UserModel> getAll(){
		return repo.findAll();
	}
	
	public void deleteById(Long Id) {
		UserModel user = repo.getById(Id);
		repo.delete(user);
	}
	
	public UserModel login(String email,String password) {
		
		UserModel user = repo.findByEmail(email).orElseThrow(()-> new RuntimeException("Invalid Email ID"));
		
		if(!security.matches(password,user.getPassword())) {
			throw new RuntimeException("Invalid Exception");
		}
		else {
			return user;
		}
		
	}
	
	
}
