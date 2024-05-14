package com.pratham.chatappbackend.service;

import java.util.List;
import java.util.Optional;

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
  public Chat crateChat(User reqUser, Integer userId2) throws UserException {

    User user = userService.findUserById(userId2);
    Chat isChatExist = chatRepository.findSingleChatByUserIds(user, reqUser);

    if (isChatExist != null) {
      return isChatExist;
    }
    Chat chat = new Chat();
    chat.setCreatedBy(reqUser);
    chat.getUsers().add(user);
    chat.getUsers().add(reqUser);
    chat.setGroup(false);
    return chat;

  }

  @Override
  public Chat findChatById(Integer chatId) throws ChatException {
    Optional<Chat> chat = chatRepository.findById(chatId);

    if (chat.isPresent()) {
      return chat.get();
    }
    throw new ChatException("Chat not found");

  }

  @Override
  public List<Chat> findAllChatByUserId(Integer UserId) throws UserException {
    User user = userService.findUserById(UserId);
    List<Chat> chats = chatRepository.findChatByUserid(user.getId());
    return chats;
  }

  @Override
  public Chat createGroup(GroupChatRequest req, User reqUser) throws UserException, ChatException {

    Chat group = new Chat();
    group.setGroup(true);
    group.setChat_image(req.getChat_image());
    group.setChat_name(req.getChat_name());
    group.setCreatedBy(reqUser);
    group.getAdmins().add(reqUser);

    for (Integer userId : req.getUserIds()) {
      User user = userService.findUserById(userId);
      group.getUsers().add(user);
    }
    return group;
  }

  @Override
  public Chat addUserToGroup(Integer userId, Integer chatId, User reqUser) throws UserException, ChatException {

    Optional<Chat> opt = chatRepository.findById(chatId);
    User user = userService.findUserById(chatId);
    if (opt.isPresent()) {
      Chat chat = opt.get();
      if (chat.getAdmins().contains(reqUser)) {
        chat.getUsers().add(user);
        return chatRepository.save(chat);
      } else {
        throw new UserException("Only Admin can add members");
      }
    }
    throw new ChatException("Chat not found");
  }

  @Override
  public Chat renameGroup(Integer chatId, String groupName, User reqUser) throws ChatException, UserException {

    Optional<Chat> opt = chatRepository.findById(chatId);
    if (opt.isPresent()) {
      Chat chat = opt.get();
      if (chat.getUsers().contains(reqUser)) {
        chat.setChat_name(groupName);
        return chatRepository.save(chat);
      }
      throw new UserException("You are not member of this group");
    }
    throw new ChatException("Chat not found");

  }

  @Override
  public Chat removeFromGroup(Integer chatId, Integer userId, User reqUser) throws UserException, ChatException {

    Optional<Chat> opt = chatRepository.findById(chatId);
    User user = userService.findUserById(chatId);

    if (opt.isPresent()) {
      Chat chat = opt.get();

      if (chat.getAdmins().contains(reqUser)) {
        chat.getUsers().remove(user);
        return chatRepository.save(chat);
      } else if (chat.getUsers().contains(reqUser)) {
        if (user.getId() == reqUser.getId()) {
          chat.getUsers().remove(user);
          return chatRepository.save(chat);
        }
      } else {
        throw new UserException("Only Admin can add members");
      }
    }
    throw new ChatException("Chat not found");
  }

  @Override
  public void deleteChat(Integer chatId, Integer reqUserId) throws ChatException, UserException {

    Optional<Chat> opt = chatRepository.findById(reqUserId);
    if (opt.isPresent()) {
      Chat chat = opt.get();
      chatRepository.deleteById(chat.getId());
    }
  }

}
