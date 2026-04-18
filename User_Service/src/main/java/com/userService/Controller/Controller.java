package com.userService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userService.Entity.UserModel;
import com.userService.service.UserService;

@RestController
@RequestMapping("/user")
public class Controller {
	
	@Autowired
    UserService userServices;
	
	 @GetMapping("/{id}")
	    public UserModel getUser(@PathVariable Long id) {
	        return userServices.getById(id);
	    }
	 
	 @GetMapping
	    public List<UserModel> getAllUsers() {
	        return userServices.getAll();
	    }
	 
	 @PostMapping("/register")
	    public ResponseEntity<UserModel> register(@RequestBody UserModel user) {
	        return ResponseEntity.ok(userServices.registerUser(user));
	    }
	

}
