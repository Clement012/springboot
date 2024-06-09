package com.example.sb.bc_forum.dto.reqout;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ForumUserDTO {

   private int id;
   private String username;
   private List<ForumCommentDTO> comments;

   @Getter
   @Setter
   @Builder
   public static class ForumCommentDTO{
      private String name;
      private String email;
      private String body;
   }
}