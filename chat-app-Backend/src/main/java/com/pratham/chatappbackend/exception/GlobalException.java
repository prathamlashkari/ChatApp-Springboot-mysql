package com.pratham.chatappbackend.exception;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

public class GlobalException {

  @ExceptionHandler(UserException.class)
  public ResponseEntity<ErrorDetials> UserExceptionHandler(UserException e, WebRequest req) {
    ErrorDetials err = new ErrorDetials(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(MessageException.class)
  public ResponseEntity<ErrorDetials> MessageExceptionHandler(UserException e, WebRequest req) {
    ErrorDetials err = new ErrorDetials(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }

  @SuppressWarnings("null")
  public ResponseEntity<ErrorDetials> MethodArgumentNotValidExceptHandler(MethodArgumentNotValidException me) {
    String error = me.getBindingResult().getFieldError().getDefaultMessage();
    ErrorDetials err = new ErrorDetials("Validation Error", error, LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ErrorDetials> handleNoHandlerException(NoHandlerFoundException e, WebRequest req) {
    ErrorDetials err = new ErrorDetials("Validation Error", req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDetials> otherExceptionHandler(Exception e, WebRequest req) {
    ErrorDetials err = new ErrorDetials(e.getMessage(), req.getDescription(false), LocalDateTime.now());
    return new ResponseEntity<ErrorDetials>(err, HttpStatus.BAD_REQUEST);
  }

}
