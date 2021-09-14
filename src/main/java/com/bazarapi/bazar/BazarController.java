package com.bazarapi.bazar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BazarController {

  @GetMapping
  public ResponseEntity<String> testing(){
    return ResponseEntity.ok("Testando");
  }

}
