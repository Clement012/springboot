package com.example.sb.bc_forum.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.sb.bc_forum.dto.reqin.PostEntityDTO;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long>{
  
  // Optional<PostEntity> findByUserId(Long userId);
  // @Query(value = "select p from PostEntity where p.userId = :userId")
  // Optional<List<PostEntity>> findByUserId

  @Query(value = "select p from PostEntity p where p.user = :userId")
  List<PostEntity> findByUserId(@Param("userId") UserEntity userId);
}
