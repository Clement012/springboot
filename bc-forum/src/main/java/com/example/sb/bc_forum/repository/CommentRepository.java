package com.example.sb.bc_forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.sb.bc_forum.dto.reqin.CommentEntityDTO;
import com.example.sb.bc_forum.entity.CommentEntity;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {


  
}
