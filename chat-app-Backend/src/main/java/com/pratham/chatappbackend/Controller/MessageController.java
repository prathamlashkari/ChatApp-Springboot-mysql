package com.pratham.chatappbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratham.chatappbackend.model.Message;
import com.pratham.chatappbackend.request.SendMessageRequest;
import com.pratham.chatappbackend.service.MessageService;
import com.pratham.chatappbackend.service.UserService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  @Autowired
  private UserService userService;

  public ResponseEntity<Message> sendMessageHandler(@RequestBody SendMessageRequest req,
      @RequestHeader("Authorization") String jwt) {

  }
}
