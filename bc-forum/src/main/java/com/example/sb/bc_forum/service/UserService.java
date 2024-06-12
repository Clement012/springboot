package com.example.sb.bc_forum.service;

import java.util.List;
import com.example.sb.bc_forum.model.User;

public interface UserService {
  
  List<User> getUsers();

  void saveUsers();

  
}
