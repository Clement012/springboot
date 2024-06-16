package com.example.sb.bc_forum.mapper.reqinmapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqin.CommentEntityDTO;
import com.example.sb.bc_forum.dto.reqin.PostEntityDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.model.User;

@Component
public class PostEntityMapper {
  
  public PostEntity mapPostEntity(Post post){  //,List<CommentEntity> commentEntities  //UserEntity userEntity,
    
    PostEntity postEntity = new PostEntity();
    // UserEntity userEntity = new UserEntity();
    postEntity.setId(Long.valueOf(post.getId()));
    postEntity.setTitle(post.getTitle());
    postEntity.setBody(post.getBody());
    // postEntity.setComments(commentEntities);
    UserEntity userEntity = new UserEntity();
    userEntity.setId(Long.valueOf(post.getUserId()));
    postEntity.setUser(userEntity);
    return postEntity;
    // postEntity.setUser(userEntity);
    // return postEntity;
  }
}
