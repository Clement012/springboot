package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.model.Post;

public interface PostService {

  List<Post> getPosts();

  void savePosts();

  List<PostEntity> getPostEntities();

  List<PostEntity> getPostByUserId(Long userId);

  PostEntity addPost(Long userId,PostEntity entity);

  PostEntity deletePostById(Long id);
} 