package com.pratham.chatappbackend.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendMessageRequest {

  private Integer userId;
  private Integer chatId;
  private String content;

}
