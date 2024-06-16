package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.model.User;

//2
public interface BcForumService {
  
  List <User> getUsers();

  List <Post> getPosts(int userId);

  List <Comment> getComments(int postId);

}
