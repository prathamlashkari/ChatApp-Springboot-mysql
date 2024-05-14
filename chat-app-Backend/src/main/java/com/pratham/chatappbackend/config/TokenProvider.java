package com.pratham.chatappbackend.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.hibernate.annotations.Comment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@SuppressWarnings("unused")
@Component
public class TokenProvider {

  SecretKey key = Keys.hmacShaKeyFor(JwtConstatns.Secret_Key.getBytes());

  public String generateToken(Authentication auths) {
    String jwt = Jwts.builder().setIssuer("By Pratham")
        .setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 86400000))
        .claim("email", auths.getName())
        .signWith(key)
        .compact();

    return jwt;
  }

  public String getEmailFromToken(String jwt) {
    jwt = jwt.substring(7);
    Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
    String email = String.valueOf(claims.get("email"));
    return email;
  }

}
