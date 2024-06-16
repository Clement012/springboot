package com.example.sb.bc_forum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Comments")
public class CommentEntity implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
  //  private int postId;
   @Column(name = "comment_name")
   private String name; 
   private String email;
   @Column(name = "comment_body",length = 10000)
   private String body; 

   @ManyToOne
  //  @JoinColumn(name = "postId")
   @JsonBackReference
   private PostEntity post;
}
