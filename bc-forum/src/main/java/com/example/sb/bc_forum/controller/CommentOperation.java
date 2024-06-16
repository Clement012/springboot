package com.example.sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.bc_forum.dto.reqout.CommentReqDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CommentOperation {
  
  @GetMapping(value = "/commentsrep/all")
  List<CommentEntity> getAllComment();

  @GetMapping(value = "/commentsrep/postid")
  List<CommentEntity> getByPostId(@RequestParam Long postId);

  @PutMapping(value = "/commentsadd/postid")
  CommentEntity addByPostId(@RequestParam Long postId,CommentEntity entity);

  @PatchMapping(value = "/commentspatch/id")
  CommentEntity updateComment(@RequestParam Long id,@RequestBody CommentReqDTO dto);
}
