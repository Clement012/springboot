package com.example.sb.bc_forum.dto.reqout;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommentReqDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body; 
}
