package com.bazarapi.bazar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice()
public class ControllerExceptionHandler {
  @ExceptionHandler(value = {NoSuchElementException.class})
  public ResponseEntity<String> handleNoSuchElementException() {
    return new ResponseEntity<String>("Product not found", HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = {Exception.class})
  public ResponseEntity<String> handleAnyException(Exception ex) {
    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}