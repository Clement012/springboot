package com.example.sb.bc_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO.ForumCommentDTO;
import com.example.sb.bc_forum.model.User;

@Component
public class ForumUserMapper {
  
  public ForumUserDTO mapForumUser(User user, List <ForumCommentDTO> forumComments){

    return ForumUserDTO.builder()
       .id(user.getId())
       .username(user.getUsername())
       .comments(forumComments)
       .build();
  }
}
