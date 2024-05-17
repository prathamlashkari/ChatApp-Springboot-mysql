package com.zos.service;

import java.util.List;

import com.zos.exception.UserException;
import com.zos.modal.User;
import com.zos.request.UpdateUserRequest;

public interface UserService {

	public User findUserProfile(String jwt);

	public User updateUser(Integer userId, UpdateUserRequest req) throws UserException;

	public User findUserById(Integer userId) throws UserException;

	public List<User> searchUser(String query);
}
