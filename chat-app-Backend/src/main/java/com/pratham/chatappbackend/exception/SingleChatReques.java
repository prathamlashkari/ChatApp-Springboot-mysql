package com.pratham.chatappbackend.exception;

import lombok.Data;

@Data
public class SingleChatReques {

  private Integer userId;

  public SingleChatReques() {
  }

  public SingleChatReques(Integer userid) {
    super();
    this.userId = userId;
  }

}
