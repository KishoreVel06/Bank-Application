package com.bank.AccountService.Service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;

@Service 
public class TokenService {

    public ResponseEntity<?> checkTokenStatus(String token) {

        String secretKey = "ThisIsTheFoundationKeyForJWTToken32Ch";
        
        
                            

        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

        try {
            Claims claims = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token.trim())
                    .getPayload();

            Date expiryDate = claims.getExpiration();
            Date now = new Date();

            if (expiryDate.before(now)) {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Token Expired");
            } else {
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body("Token Valid. Expiry time: " + expiryDate);
            }

        } catch (ExpiredJwtException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Token Expired: " + e.getMessage());

        } catch (UnsupportedJwtException |
                 MalformedJwtException |
                 SecurityException |
                 IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid Token: " + e.getMessage());
        }
    }
}