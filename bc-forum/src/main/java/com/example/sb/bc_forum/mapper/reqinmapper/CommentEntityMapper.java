package com.example.sb.bc_forum.mapper.reqinmapper;

import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.model.Comment;

@Component
public class CommentEntityMapper {
  
  public CommentEntity mapCommentEntity(Comment comment){ //PostEntity postEntity,
    // return CommentEntityDTO.builder()
    CommentEntity commentEntity = new CommentEntity();

    commentEntity.setId(Long.valueOf(comment.getId()));
    commentEntity.setName(comment.getName());
    commentEntity.setEmail(comment.getEmail());
    commentEntity.setBody(comment.getBody());
    // commentEntity.setPost(postEntity);
    return commentEntity;
       
  }
}
