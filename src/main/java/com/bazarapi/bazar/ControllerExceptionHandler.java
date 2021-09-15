package com.bazarapi.bazar;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class ControllerExceptionHandler {
//  @ExceptionHandler(value = { Exception.class })
//  public ResponseEntity<String> handleAnyException(Exception ex) {
//    return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    return new ResponseEntity<String>("OIE", HttpStatus.INTERNAL_SERVER_ERROR);
//  }
}