package com.pratham.chatappbackend.service;

import java.util.List;

import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.UpdateUserRequest;

public interface UserService {

  public User findUserById(Integer id) throws UserException;

  public User findUserProfile(String jwt) throws UserException;

  public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;

  public List<User> search(String query);
}
