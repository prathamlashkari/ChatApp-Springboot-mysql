package com.pratham.chatappbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratham.chatappbackend.config.TokenProvider;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.repository.UserRepository;
import com.pratham.chatappbackend.request.UpdateUserRequest;

public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenProvider tokenProvider;

  @Override
  public User findUserById(Integer id) throws UserException {

    Optional<User> opt = userRepository.findById(id);
    if (opt.isPresent()) {
      return opt.get();
    }
    throw new UserException("UserNot found ");
  }

  @Override
  public User findUserProfile(String jwt) throws UserException {
    String email = tokenProvider.getEmailFromToken(jwt);
    if (email == null) {
      throw new UserException("User not found");
    }
    User user = userRepository.findByEmail(email);
    if (user == null) {
      throw new UserException("User not found");
    }
    return user;
  }

  @Override
  public User updateUser(Integer userId, UpdateUserRequest req) throws UserException {
    User user = userRepository.findUserById(userId);
    if (req.getFull_name() != null) {
      user.setFull_name(req.getFull_name());
    }
    if (req.getProfile_picture() != null) {
      user.setProfile_picutre(req.getProfile_picture());
    }
    return userRepository.save(user);
  }

  @Override
  public List<User> search(String query) {
    List<User> users = userRepository.searchUser(query);
    return users;
  }

}
