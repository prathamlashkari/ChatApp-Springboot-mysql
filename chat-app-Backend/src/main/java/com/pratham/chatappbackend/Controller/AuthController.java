package com.pratham.chatappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.chatappbackend.config.TokenProvider;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.repository.UserRepository;
import com.pratham.chatappbackend.response.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenProvider tokenProvider;

  @PostMapping("/signup")
  public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws UserException {

    String email = user.getEmail();
    String full_name = user.getFull_name();
    String password = user.getPassword();

    User isUser = userRepository.findByEmail(email);

    if (isUser != null) {
      throw new UserException("Email is used with another account ");
    }
    User createUser = new User();
    createUser.setEmail(email);
    createUser.setFull_name(full_name);
    createUser.setPassword(password);

    userRepository.save(createUser);
    Authentication authentication = new UsernamePasswordAuthenticationToken(email, password);
    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);

    AuthResponse res = new AuthResponse(jwt, true);
    return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
  }

}
