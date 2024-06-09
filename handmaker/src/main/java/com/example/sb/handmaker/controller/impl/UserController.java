package com.example.sb.handmaker.controller.impl;

import com.example.sb.handmaker.controller.UserOperation;
import com.example.sb.handmaker.model.User;

public class UserController implements UserOperation {
  
  @Override
  public addUser(String p){
    String p1 = "";
    try {
      p1 = p;
    } catch (RuntimeException e) {
      return "user is not exist.";
    }
    return String p;
  }
}
