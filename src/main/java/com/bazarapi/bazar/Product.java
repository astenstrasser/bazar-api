package com.bazarapi.bazar;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

  @Id
  private String _id;

  @NonNull
  private String name;
  @NonNull
  private Number price;
  private String details;
  private String imageUrl;
  private String imageAltText;
}
