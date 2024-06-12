package com.example.sb.modelmapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sb.modelmapper.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
  
}
