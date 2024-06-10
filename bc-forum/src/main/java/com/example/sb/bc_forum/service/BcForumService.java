package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.exceptions.RestTemplateException;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.model.User;

public interface BcForumService {
  
  List <User> getUsers() ;

  List <Post> getPosts(int userId);

  List <Comment> getComments(int postId);

  //3a
  // List<UserDTO> getAllByUserId(int userID);
  // //3b
  // UserDTO getForumData(int userID);
}
