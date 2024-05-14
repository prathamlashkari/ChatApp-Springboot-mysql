package com.pratham.chatappbackend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.MessageException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.Message;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.repository.MessageRepository;
import com.pratham.chatappbackend.request.SendMessageRequest;

public class MessageServiceImpl implements MessageService {

  @Autowired
  private MessageRepository messageRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private ChatService chatService;

  @Override
  public Message sendMessage(SendMessageRequest req) throws UserException, ChatException {

    User user = userService.findUserById(req.getUserId());
    Chat chat = chatService.findChatById(req.getChatId());

    Message message = new Message();
    message.setChat(chat);
    message.setUser(user);
    message.setContent(req.getContent());
    message.setTimestamps(LocalDateTime.now());
    return message;
  }

  @Override
  public List<Message> getChatsMessage(Integer chatId, User reqUser)
      throws ChatException, UserException {

    Chat chat = chatService.findChatById(chatId);

    if (!chat.getUsers().contains(reqUser)) {
      throw new UserException("You are not selected to this chat");
    }
    List<Message> messages = messageRepository.findByChatId(chat.getId());
    return messages;

  }

  @Override
  public Message findMessageById(Integer messageId) throws MessageException {

    throw new UnsupportedOperationException("Unimplemented method 'findMessageById'");
  }

  @Override
  public void deleteMessage(Integer messageId, User reqUser) throws MessageException {

    throw new UnsupportedOperationException("Unimplemented method 'deleteMessage'");
  }

}
