package com.pratham.chatappbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.repository.ChatRepository;
import com.pratham.chatappbackend.request.GroupChatRequest;

public class ChatServiceImpl implements ChatService {

  @Autowired
  private ChatRepository chatRepository;

  @Autowired
  private UserService userService;

  @Override
  public Chat crateChat(User reqUser, Integer userId2, boolean isGroup) throws UserException {
    throw new UnsupportedOperationException("Unimplemented method 'crateChat'");
  }

  @Override
  public Chat findChatById(Integer chatId) throws ChatException {
    throw new UnsupportedOperationException("Unimplemented method 'crateChat'");

  }

  @Override
  public List<Chat> findAllChatByUserId(Integer UserId) throws UserException {
    throw new UnsupportedOperationException("Unimplemented method 'findAllChatByUserId'");
  }

  @Override
  public Chat createGroup(GroupChatRequest req, Integer reqUserId) throws UserException, ChatException {
    throw new UnsupportedOperationException("Unimplemented method 'createGroup'");
  }

  @Override
  public Chat addUserToGroup(Integer userId, Integer chatId) throws UserException, ChatException {
    throw new UnsupportedOperationException("Unimplemented method 'addUserToGroup'");
  }

  @Override
  public Chat renameGroup(Integer chatId, String groupName, Integer reqUserId) throws ChatException, UserException {
    throw new UnsupportedOperationException("Unimplemented method 'renameGroup'");
  }

  @Override
  public Chat removeFromGroup(Integer chatId, Integer userId, Integer reqUser) throws UserException, ChatException {
    throw new UnsupportedOperationException("Unimplemented method 'removeFromGroup'");
  }

  @Override
  public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException {
    throw new UnsupportedOperationException("Unimplemented method 'deleteChat'");
  }

}
