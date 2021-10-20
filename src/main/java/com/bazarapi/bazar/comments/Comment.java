package com.bazarapi.bazar.comments;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {
  private String _id;
  private String name;
  private String email;
  private String productId;
  private String text;
  private String timestamp;
}
