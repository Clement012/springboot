package com.example.sb.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sb.bc_forum.dto.reqin.CommentEntityDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

  @Query(value = "select c from CommentEntity c where c.post = :postId")
  List<CommentEntity> findByPostId(@Param("postId") PostEntity postId);
}
