package com.pratham.chatappbackend.exception;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class ErrorDetials {

  private String error;
  private String message;
  private LocalDateTime time;

  public ErrorDetials() {
  }

  public ErrorDetials(String error, String message, LocalDateTime time) {
    this.error = error;
    this.message = message;
    this.time = time;
  }

}
