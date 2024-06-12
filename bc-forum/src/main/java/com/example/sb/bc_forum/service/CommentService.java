package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.model.Comment;

public interface CommentService {
  
  List <Comment> getComments();

  void saveComments();

}
