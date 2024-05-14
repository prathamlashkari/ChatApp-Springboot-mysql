package com.pratham.chatappbackend.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRequest {

  private String full_name;
  private String profile_picture;

}
