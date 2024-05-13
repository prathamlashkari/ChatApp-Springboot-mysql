package com.pratham.chatappbackend.config;

import java.io.IOException;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

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
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();

        String username = String.valueOf(claims.get("username"));
        String authorities = String.valueOf(claims.get("authorities"));

        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);

        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, auths);

        SecurityContextHolder.getContext().setAuthentication(authentication);

      } catch (Exception e) {
        throw new BadCredentialsException("Invalid token received");
      }

    }
    filterChain.doFilter(request, response);
  }

}
