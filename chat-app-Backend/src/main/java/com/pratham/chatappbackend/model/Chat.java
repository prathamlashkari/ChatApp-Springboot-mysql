package com.pratham.chatappbackend.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Chat {

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

}
