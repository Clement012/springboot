package com.example.sb.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.bc_forum.controller.UserOperation;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.infra.ApiResp;
import com.example.sb.bc_forum.service.UserService;

@RestController
public class UserController implements UserOperation{

  @Autowired
  private UserService userService;

   @Override // 3-users
  public List<UserEntity> getAllUser(){ 
    return userService.getUserEntities();
  }

  @Override //3-userByid
  public UserEntity getUserById(Long id) { 
     return userService.getUserById(id);
   }

   //3-putUser
  @Override
  public UserEntity updateUser(Long id, UserEntity entity){ 
      return userService.updateUser(id,entity);
    }
}
