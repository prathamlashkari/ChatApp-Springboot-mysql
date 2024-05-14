package com.pratham.chatappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.chatappbackend.config.JwtConstatns;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.UpdateUserRequest;
import com.pratham.chatappbackend.response.ApiResponse;
import com.pratham.chatappbackend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/profile")
  public ResponseEntity<User> getUserProfileHandler(@RequestHeader(JwtConstatns.Jwt_Header) String token)
      throws UserException {
    User user = userService.findUserProfile(token);
    return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
  }

  @GetMapping("/{query}")
  public ResponseEntity<List<User>> searchUserHandler(@PathVariable("query") String q) {
    List<User> users = userService.search(q);
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }

  @PutMapping("/update")
  public ResponseEntity<ApiResponse> updateUserHandler(@RequestBody UpdateUserRequest req,
      @RequestHeader(JwtConstatns.Jwt_Header) String token) throws UserException {

    User user = userService.findUserProfile(token);

    userService.updateUser(user.getId(), req);
    ApiResponse res = new ApiResponse("User updated successfully ", true);
    return new ResponseEntity<ApiResponse>(res, HttpStatus.ACCEPTED);
  }

}
