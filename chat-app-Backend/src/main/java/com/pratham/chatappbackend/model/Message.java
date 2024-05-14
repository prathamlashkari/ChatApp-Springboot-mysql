package com.pratham.chatappbackend.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private String content;

  private LocalDateTime timestamps;

  @ManyToOne
  private User user;

  @ManyToOne
  private Chat chat;

}
