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
  public int id;
  public String full_name;
  public String email;
  public String profile_picutre;
  public String password;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    if (id != other.id)
      return false;
    if (full_name == null) {
      if (other.full_name != null)
        return false;
    } else if (!full_name.equals(other.full_name))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (profile_picutre == null) {
      if (other.profile_picutre != null)
        return false;
    } else if (!profile_picutre.equals(other.profile_picutre))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((full_name == null) ? 0 : full_name.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((profile_picutre == null) ? 0 : profile_picutre.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    return result;
  }

  // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  // List<Notification> Notification = new ArrayList<>();

}
