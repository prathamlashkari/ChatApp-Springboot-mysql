package com.pratham.chatappbackend.service;

import java.util.List;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.GroupChatRequest;

public interface ChatService {

  public Chat crateChat(User reqUser, Integer userId2) throws UserException;

  public Chat findChatById(Integer chatId) throws ChatException;

  public List<Chat> findAllChatByUserId(Integer UserId) throws UserException;

  public Chat createGroup(GroupChatRequest req, User reqUser) throws UserException, ChatException;

  public Chat addUserToGroup(Integer userId, Integer chatId, User reqUser) throws UserException, ChatException;

  public Chat renameGroup(Integer chatId, String groupName, User reqUser) throws ChatException, UserException;

  public Chat removeFromGroup(Integer chatId, Integer userId, User reqUser) throws UserException, ChatException;

  public void deleteChat(Integer chatId, Integer reqUserId) throws ChatException, UserException;
}
