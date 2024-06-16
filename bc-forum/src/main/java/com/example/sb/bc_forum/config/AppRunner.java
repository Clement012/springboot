package com.example.sb.bc_forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.service.CommentService;
import com.example.sb.bc_forum.service.PostService;
import com.example.sb.bc_forum.service.UserService;

@Component
public class AppRunner implements CommandLineRunner{

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;
  
  @Autowired
  private CommentService commentService;

  @Override
  //DependsOn({"userServiceImpl", "postServiceImpl","commentServiceImpl"})
  public void run(String... args){
    userService.saveUsers();
    postService.savePosts();
    commentService.saveComments();
  }
}
