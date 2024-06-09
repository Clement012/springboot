package com.example.sb.bc_forum.mapper;

import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO.CommentDTO;
import com.example.sb.bc_forum.model.Comment;

@Component
public class CommentMapper {
  
  public  CommentDTO mapComment(Comment comment){
    return CommentDTO.builder() // single //get raw data from comment
    .postId(comment.getPostId())
    .id(comment.getId())
    .name(comment.getName())
    .email(comment.getEmail())
    .body(comment.getBody())
    .build();
  }
}

