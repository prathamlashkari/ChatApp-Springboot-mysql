package com.pratham.chatappbackend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Chat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;
  private String chat_name;
  private String chat_image;

  @JoinColumn(name = "is_group")
  private boolean isGroup;

  @JoinColumn(name = "created_by")
  @ManyToOne
  private User createdBy;

  @ManyToMany
  private Set<User> users = new HashSet<>();
  @ManyToMany
  private Set<User> admins = new HashSet<>();

  public Chat() {
  }

  @OneToMany
  private List<Message> message = new ArrayList<>();

  public Chat(Integer id, String chat_name, String chat_image, boolean isGroup, User createdBy, Set<User> users,
      Set<User> admins,
      List<Message> message) {
    Id = id;
    this.chat_name = chat_name;
    this.chat_image = chat_image;
    this.isGroup = isGroup;
    this.createdBy = createdBy;
    this.users = users;
    this.message = message;
    this.admins = admins;
  }

}
