package com.example.sb.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sb.bc_forum.controller.PostOperation;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.service.PostService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/post")
public class PostController implements PostOperation{
  
  @Autowired
  private PostService postService;

  //3-getPost
  @Override
  public List<PostEntity> getAllPost(){
    return postService.getPostEntities();
  }

  //3-getPostByUserId
    @Override
    public List<PostEntity> getPostByUserId(Long userId){  
      return postService.getPostByUserId(userId);
    }
  
  //3-addPost
    @Override
    public PostEntity addPost(Long userId,PostEntity entity){
      return postService.addPost(userId,entity);
    }

  //3-deletePost
  @Override
  public PostEntity deletePostById(Long id){
    return postService.deletePostById(id);
  }
}
