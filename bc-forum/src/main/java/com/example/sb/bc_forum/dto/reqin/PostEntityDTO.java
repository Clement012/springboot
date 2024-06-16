package com.example.sb.bc_forum.dto.reqin;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostEntityDTO {
  private String title;
  private String body;
  private List<CommentEntityDTO> comments; 
}
