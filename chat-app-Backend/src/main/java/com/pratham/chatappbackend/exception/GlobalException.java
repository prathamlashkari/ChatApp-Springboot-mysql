package com.pratham.chatappbackend.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

public class GlobalException {

  public ResponseEntity<ErrorDetials> UserExceptionHandler(UserException e, WebRequest req) {

    ErrorDetials err = new ErrorDetials(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }
}
