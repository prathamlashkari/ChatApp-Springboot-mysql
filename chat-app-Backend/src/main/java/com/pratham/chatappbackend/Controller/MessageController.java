package com.pratham.chatappbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.chatappbackend.exception.ChatException;
import com.pratham.chatappbackend.exception.MessageException;
import com.pratham.chatappbackend.exception.UserException;
import com.pratham.chatappbackend.model.Message;
import com.pratham.chatappbackend.model.User;
import com.pratham.chatappbackend.request.SendMessageRequest;
import com.pratham.chatappbackend.response.ApiResponse;
import com.pratham.chatappbackend.service.MessageService;
import com.pratham.chatappbackend.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @Autowired
  private UserService userService;

  @PostMapping("/create")
  public ResponseEntity<Message> sendMessageHandler(@RequestBody SendMessageRequest req,
      @RequestHeader("Authorization") String jwt) throws UserException, ChatException {

    User user = userService.findUserProfile(jwt);
    req.setUserId(user.getId());
    Message message = messageService.sendMessage(req);
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @GetMapping("/chat/{chatId}")
  public ResponseEntity<List<Message>> getChatsMessageHandler(@PathVariable Integer chatId,
      @RequestHeader("Authorization") String jwt) throws UserException, ChatException {

    User user = userService.findUserProfile(jwt);
    List<Message> message = messageService.getChatsMessage(chatId, user);
    return new ResponseEntity<>(message, HttpStatus.OK);
  }

  @DeleteMapping("/{messageId}")
  public ResponseEntity<ApiResponse> deleteMessageHandler(@PathVariable Integer messageId,
      @RequestHeader("Authorization") String jwt) throws UserException, ChatException, MessageException {

    User user = userService.findUserProfile(jwt);
    messageService.deleteMessage(messageId, user);
    ApiResponse res = new ApiResponse("message deleted successfully", false);
    return new ResponseEntity<>(res, HttpStatus.OK);
  }

}
