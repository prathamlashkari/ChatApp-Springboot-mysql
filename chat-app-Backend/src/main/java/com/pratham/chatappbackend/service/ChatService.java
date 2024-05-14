package com.pratham.chatappbackend.service;

import java.util.List;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.GroupChatRequest;

public interface ChatService {

  public Chat crateChat(User reqUser, Integer userId2, boolean isGroup) throws UserException;

  public Chat findChatById(Integer chatId) throws ChatException;

  public List<Chat> findAllChatByUserId(Integer UserId) throws UserException;

  public Chat createGroup(GroupChatRequest req, Integer reqUserId) throws UserException, ChatException;

  public Chat addUserToGroup(Integer userId, Integer chatId) throws UserException, ChatException;

  public Chat renameGroup(Integer chatId, String groupName, Integer reqUserId) throws ChatException, UserException;

  public Chat removeFromGroup(Integer chatId, Integer userId, Integer reqUser) throws UserException, ChatException;

  public Chat deleteChat(Integer chatId, Integer userId) throws ChatException, UserException;
}
