package com.example.sb.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO.ForumCommentDTO;
import com.example.sb.bc_forum.model.Comment;


@Component
public class ForumCommentMapper {
  
  public ForumCommentDTO mapForumCommentDTO(Comment comment){
    return ForumCommentDTO.builder()
       .name(comment.getName())
       .email(comment.getEmail())
       .body(comment.getBody())
       .build();
  }
}
