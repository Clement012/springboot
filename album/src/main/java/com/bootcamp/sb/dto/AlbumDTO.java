package com.bootcamp.sb.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AlbumDTO {
  
  private int userId;
  // private int id;   
  private String title;
}
