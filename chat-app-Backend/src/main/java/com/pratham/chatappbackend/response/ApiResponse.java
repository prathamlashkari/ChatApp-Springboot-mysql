package com.pratham.chatappbackend.response;

public class ApiResponse {

  private String message;
  private boolean status;

  public ApiResponse(String msg, boolean b) {
    this.message = msg;
    this.status = b;
  }
}
