package com.pratham.chatappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.SingleChatReques;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Chat;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.GroupChatRequest;
import com.pratham.chatappbackend.service.ChatService;
import com.pratham.chatappbackend.service.UserService;
import com.pratham.chatappbackend.config.JwtConstatns;

@RestController
@RequestMapping("/api/chats")
public class ChatController {

  @Autowired
  private UserService userService;

  @Autowired
  private ChatService chatService;

  @PostMapping("/single")
  public ResponseEntity<Chat> createChatHandler(@RequestBody SingleChatReques singleChatRequest,
      @RequestHeader("Authorization") String jwt) throws UserException {

    User reqUser = userService.findUserProfile(jwt);
    Chat chat = chatService.crateChat(reqUser, singleChatRequest.getUserId());

    return new ResponseEntity<Chat>(chat, HttpStatus.OK);

  }

  @PostMapping("/group")
  public ResponseEntity<Chat> createGroupHandler(@RequestBody GroupChatRequest req,
      @RequestHeader("Authorization") String jwt) throws UserException, ChatException {
    User reqUser = userService.findUserProfile(jwt);
    Chat chat = chatService.createGroup(req, reqUser);
    return new ResponseEntity<Chat>(chat, HttpStatus.OK);
  }

  @GetMapping("/{chatid}")
  public ResponseEntity<Chat> findChatByIdHadnler(@PathVariable Integer chatid,
      @RequestHeader("Authorization") String jwt) throws UserException, ChatException {
    Chat chat = chatService.findChatById(chatid);
    return new ResponseEntity<Chat>(chat, HttpStatus.OK);
  }

  @GetMapping("/user")
  public ResponseEntity<List<Chat>> createGroupHandler(@RequestHeader("Authorization") String jwt)
      throws UserException {

    User req = userService.findUserProfile(jwt);
    List<Chat> chats = chatService.findAllChatByUserId(req.getId());
    return new ResponseEntity<List<Chat>>(chats, HttpStatus.OK);

  }

}
