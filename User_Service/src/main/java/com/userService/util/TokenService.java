package com.userService.util;

import java.time.Duration;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class TokenService {

	public  String getToken(String userName, String passWord) {

        String secretKey = "ThisIsTheFoundationKeyForJWTToken32Ch";
        String expiryStr = "PT5M";
        Duration expiryDuration = Duration.parse(expiryStr);
        long expiryMillis = expiryDuration.toMillis();

        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expiryDate = new Date(now + expiryMillis);

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        return Jwts.builder()
                .subject(userName)        // ✅ new method
                .issuedAt(issuedAt)       // ✅ new method
                .expiration(expiryDate)   // ✅ new method
                .signWith(key)            // ✅ no need to pass algorithm separately
                .compact();
    
	}
	
	

}
