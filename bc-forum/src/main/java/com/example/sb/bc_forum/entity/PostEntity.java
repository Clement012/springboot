package com.example.sb.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Posts")
public class PostEntity implements Serializable{
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  // private int userId;
  private String title;
  @Column(name = "post_body")
  private String body;

  @ManyToOne
  // @JoinColumn(name = "userId")
  @JsonBackReference
  @Setter
  private UserEntity user;

  @OneToMany (cascade = {CascadeType.ALL})
  @JsonManagedReference
  @JoinColumn(name = "post_id")
  private List<CommentEntity> comments = new ArrayList<>();
}
