package com.example.sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.infra.ApiResp;

public interface UserOperation {
  
  //3-users
  @GetMapping(value = "/usersrep/all")
  List<UserEntity> getAllUser();

  //3-userByid
  @GetMapping(value = "/usersrep/id")
  UserEntity getUserById(@RequestParam Long id); 

  //3-putUser
  @PutMapping(value = "/usersrep/update")
  UserEntity updateUser(@RequestParam Long id,@RequestBody UserEntity entity);
}
