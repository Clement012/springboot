package com.example.sb.handmaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.sb.handmaker.model.User;

public interface UserOperation {
  
  @GetMapping(value = "/user/username/{name}")
  User addUser(String name);
}
