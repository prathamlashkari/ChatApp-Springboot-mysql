package com.pratham.chatappbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int Id;
  public String name;
  public String username;
  public int password;

}
