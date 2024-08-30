package com.prashu.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {

    SecretKey key = Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());

    public String generateToken(Authentication auth){
        long EXPIRATIONTIME = 365 * 24 * 60 * 60 * 1000L;
        String jwt = Jwts.builder().setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                .claim("email",auth.getName())
                .signWith(key).compact();
        return jwt;
    }

    public  String getEmailFromToken(String jwt){
        if (jwt != null && jwt.startsWith("Bearer ")){
            jwt = jwt.substring(7);
        }

        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        String email = String.valueOf(claims.get("email"));
        return email;
    }

}
