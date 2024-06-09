package com.example.sb.bc_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO.CommentDTO;
import com.example.sb.bc_forum.model.Post;

@Component
public class PostMapper {

    public  PostDTO mapPost(Post post,List<CommentDTO> comments){

     return PostDTO.builder()
      .userId(post.getUserId())
      .id(post.getId())
      .title(post.getTitle())
      .body(post.getBody())
      .comments(comments)
      .build();
  }
}