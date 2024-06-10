package com.example.sb.bc_forum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class CommentEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private int postId;
   @Column(name = "comment_name")
   private String name;
   private String email;
   @Column(name = "comment_body")
   private String body;

}
