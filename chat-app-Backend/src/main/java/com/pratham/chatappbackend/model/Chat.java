package com.pratham.chatappbackend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
  private String chag_image;

  @Column(name = "is_group")
  private boolean isGroup;

  @Column
  @ManyToOne
  private User createdBy;

  @ManyToOne
  private Set<User> user = new HashSet<>();

  @OneToMany
  private List<Message> message = new ArrayList<>();

  public Chat(Integer id, String chat_name, String chag_image, boolean isGroup, User createdBy, Set<User> user,
      List<Message> message) {
    Id = id;
    this.chat_name = chat_name;
    this.chag_image = chag_image;
    this.isGroup = isGroup;
    this.createdBy = createdBy;
    this.user = user;
    this.message = message;
  }

  public Chat() {

  }

}
