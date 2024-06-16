package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.infra.ApiResp;

public interface UserService {
  
  List<User> getUsers();

  void saveUsers();

  List<UserEntity> getUserEntities();

  UserEntity getUserById(Long id);

  UserEntity updateUser(Long id,UserEntity entity);
}
