package com.example.thymyleaf.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDTO {
  private int userId;
  private int id;
  private String title;
  // private String body;
}
