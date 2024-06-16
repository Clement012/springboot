package com.example.sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.bc_forum.entity.PostEntity;

public interface PostOperation {
  
  //3-getPost
  @GetMapping(value = "/postsrep/all")
  List<PostEntity> getAllPost();

  //3-getPostByUserId
  @GetMapping(value = "/postsrep/{userId}") 
  List<PostEntity> getPostByUserId(@PathVariable Long userId);

  //3-addPost
  @PutMapping(value = "/postsadd/{userId}")
  PostEntity addPost(@PathVariable Long userId,@RequestBody PostEntity entity);

  //3-deletepost
  @DeleteMapping(value = "/postsdelete/postId")
  PostEntity deletePostById(@RequestParam Long id);
}
