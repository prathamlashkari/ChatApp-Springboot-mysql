package com.pratham.chatappbackend.service;

import java.util.List;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.MessageException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Message;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.SendMessageRequest;

public interface MessageService {

  public Message sendMessage(SendMessageRequest req) throws UserException, ChatException;

  public List<Message> getChatsMessage(Integer chatID, User reqUser)
      throws ChatException, UserException;

  public Message findMessageById(Integer messageId) throws MessageException;

  public void deleteMessage(Integer messageId, User reqUser) throws MessageException;

}
