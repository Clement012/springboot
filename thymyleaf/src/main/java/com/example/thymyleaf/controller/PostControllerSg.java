package com.example.thymyleaf.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.thymyleaf.dto.PostDTO;
import com.example.thymyleaf.mapper.PostMapper;
import com.example.thymyleaf.model.Post;
import com.example.thymyleaf.service.PostService;

@RestController
@RequestMapping(value = "/sg")
public class PostControllerSg {

  @Autowired
  private PostService postService;

  @Autowired
  private PostMapper postMapper;
  
  @GetMapping(value = "/post")
  public List<PostDTO> getPost(){
    return postService.getPost().stream() 
       .map(p -> postMapper.map(p))
       .collect(Collectors.toList());
  }
}

