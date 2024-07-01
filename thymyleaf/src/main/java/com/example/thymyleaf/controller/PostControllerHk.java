package com.example.thymyleaf.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.thymyleaf.model.Post;
import com.example.thymyleaf.service.PostService;

@RestController
@RequestMapping(value = "/hk")
public class PostControllerHk {

  @Autowired
  private PostService postService;
  
  @GetMapping(value = "/post")
  public List<Post> getPost(){
    return postService.getPost();
   }
  }


