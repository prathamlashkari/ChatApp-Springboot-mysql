package com.pratham.chatappbackend.config;

import java.io.IOException;

import javax.crypto.SecretKey;

import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter {

  @SuppressWarnings("null")
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String jwtToken = request.getHeader(JwtConstatns.Jwt_Header);
    if (jwtToken != null) {
      try {

        SecretKey key = Keys.hmacShaKeyFor(JwtConstatns.Secret_Key.getBytes());
        // Claims claims = Jwts.parserBuilder().

      } catch (Exception e) {

      }

    }
  }

}
