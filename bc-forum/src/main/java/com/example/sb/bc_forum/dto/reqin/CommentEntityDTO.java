package com.example.sb.bc_forum.dto.reqin;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentEntityDTO {
  private String name;
  private String email;
  private String body;
}
