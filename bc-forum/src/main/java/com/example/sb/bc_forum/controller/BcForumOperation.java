package com.example.sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.entity.CommentEntity;


public interface BcForumOperation {

  //2-3a
  @GetMapping(value = "/users/all")  
  List<UserDTO> getAllById(); 

  //2-3b
  @GetMapping(value = "/users/comment")
  ForumUserDTO getForumData(@RequestParam int id);

  //3-users
  @GetMapping(value = "/usersrep/all")
  List<UserEntity> getAllUser();

  //3-userByid
  @GetMapping(value = "/usersrep/id")
  UserEntity getUserById(@RequestParam Long id); 

  //3-putUser
  @PutMapping(value = "/usersrep/update")
  UserEntity updateUser(@RequestParam Long id,@RequestBody UserEntity entity);

  //3-getPost
  @GetMapping(value = "/postsrep/all")
  List<PostEntity> getAllPost();

  //3-getPostByUserId
  @GetMapping(value = "/postsrep/userid")
  PostEntity getPostByUserId(@RequestParam Long userId);

  //3-getComment
  @GetMapping(value = "/commentsrep/all")
  List<CommentEntity> getAllComment();
} 