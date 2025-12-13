package com.example.demo.config.Jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.demo.Dtos.Roles;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String email,  Roles rol, Long storeU_id, String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .subject(email)
                .claim("rol", "ROLE_" + rol.name())
                .claim("storeU_id", storeU_id)
                .claim("username", username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey()) // Cambio: setSigningKey -> verifyWith
                .build()
                .parseSignedClaims(token)    // Cambio: parseClaimsJws -> parseSignedClaims
                .getPayload();               // Cambio: getBody -> getPayload
    }


    public String getEmailFromToken(String token) {
        return getAllClaimsFromToken(token).getSubject();
    }

    public String getUserNameFromToken(String token) {
        return getAllClaimsFromToken(token).get("username", String.class);
    }

    public String getRoleFromToken(String token) {
        return getAllClaimsFromToken(token).get("rol", String.class);
    }

    public Long getStoreFromToken(String token) {
        return getAllClaimsFromToken(token).get("storeU_id", Long.class);
    }



    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}