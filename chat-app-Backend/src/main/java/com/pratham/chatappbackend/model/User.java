package com.pratham.chatappbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int Id;
  public String full_name;
  public String email;
  public String profile_picutre;
  public String password;

  // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  // List<Notification> Notification = new ArrayList<>();

}
