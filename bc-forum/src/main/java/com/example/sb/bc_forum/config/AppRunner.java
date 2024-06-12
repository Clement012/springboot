package com.example.sb.bc_forum.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.service.impl.CommentServiceImpl;
import com.example.sb.bc_forum.service.impl.PostServiceImpl;
import com.example.sb.bc_forum.service.impl.UserServiceImpl;

@Component
public class AppRunner implements CommandLineRunner{

  @Autowired
  private UserServiceImpl userServiceImpl;

  @Autowired
  private PostServiceImpl postServiceImpl;
  
  @Autowired
  private CommentServiceImpl commentServiceImpl;

  @Override
  @DependsOn({"userServiceImpl", "postServiceImpl","commentServiceImpl"})
  public void run(String... args){
    userServiceImpl.saveUsers();
    postServiceImpl.savePosts();
    commentServiceImpl.saveComments();
  }
}
