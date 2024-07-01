package com.example.sb.bc_forum.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.sb.bc_forum.controller.CommentOperation;
import com.example.sb.bc_forum.dto.reqout.CommentReqDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController implements CommentOperation{
  
  @Autowired
  private CommentService commentService;

  @Override //get comment
  public List<CommentEntity> getAllComment(){
    return commentService.getCommentEntities();
  }

  @Override //get By post id
  public List<CommentEntity> getByPostId(Long postId){
    return commentService.getByPostId(postId);
  }
  
  @Override
  public CommentEntity addByPostId(Long postId,CommentEntity entity){
    return commentService.addByPostId(postId,entity);
  }

  @Override
  public CommentEntity updateComment(Long id,CommentReqDTO dto){
    return commentService.updateComment(id,dto);
  }
}
