package com.userService.util;

import java.util.Optional;
import com.userService.Entity.UserModel;    
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.userService.repository.UserRepository;

@Component
public class getRequestWithToken {

    @Autowired
    private TokenService tokenService; 
    
    @Autowired 
    private UserRepository userRepository;
    
    public ResponseEntity<?> validateInput(String userName, String passWord) {

        try {
            if (userName != null && passWord != null 
                && !userName.isEmpty() && !passWord.isEmpty()) {
            	
            	
                Optional<UserModel> userOptional = userRepository.findByName(userName); // ✅
            	
            	if(userOptional.isEmpty()) {
            		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
            	}
            	
            	UserModel user = userOptional.get();
            	
            	 if (!user.getPassword().equals(passWord)) {
                     return ResponseEntity
                             .status(HttpStatus.UNAUTHORIZED)
                             .body("Invalid password!");
                 }

                String token = tokenService.getToken(userName, passWord); 
                return ResponseEntity.ok(token); // ✅ wrap in ResponseEntity
            } else {
                return ResponseEntity
                        .badRequest()
                        .body("Username or Password cannot be empty"); // ✅ proper error
            }

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while generating token: " + e.getMessage()); // ✅ fixed return type
        }
    }
}