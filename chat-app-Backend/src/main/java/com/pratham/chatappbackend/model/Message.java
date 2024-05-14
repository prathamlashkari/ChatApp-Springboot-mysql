package com.pratham.chatappbackend.model;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private String content;

  private LocalDateTime timestamps;

  @ManyToOne
  private User user;

  @ManyToOne
  @JoinColumn(name = "chat_id")
  private Chat chat;

  public Message() {
  }

  public Message(Integer id, String content, LocalDateTime timestamps, User user, Chat chat) {
    Id = id;
    this.content = content;
    this.timestamps = timestamps;
    this.user = user;
    this.chat = chat;
  }

}
