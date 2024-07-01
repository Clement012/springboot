package com.example.thymyleaf.mapper;

import org.springframework.stereotype.Component;
import com.example.thymyleaf.dto.PostDTO;
import com.example.thymyleaf.model.Post;

@Component
public class PostMapper {
  public PostDTO map(Post post){

    return PostDTO.builder()
       .id(post.getId())
       .userId(post.getUserId())
       .title(post.getTitle())
       .build();
  }
}
