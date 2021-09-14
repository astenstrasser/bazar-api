package com.bazarapi.bazar;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Bazar {

  @Id
  private UUID uuid;

  public String produto;

}
