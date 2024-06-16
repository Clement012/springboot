package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.dto.reqout.CommentReqDTO;
import com.example.sb.bc_forum.entity.CommentEntity;

public interface CommentService {
  
  List <Comment> getComments();

  void saveComments();

  List <CommentEntity> getCommentEntities();

  List <CommentEntity> getByPostId(Long postId);

  CommentEntity addByPostId(Long postId,CommentEntity entity);

  CommentEntity updateComment(Long id,CommentReqDTO dto);
}
