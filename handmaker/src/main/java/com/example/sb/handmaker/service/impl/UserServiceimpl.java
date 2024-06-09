package com.example.sb.handmaker.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.sb.handmaker.model.User;
import com.example.sb.handmaker.service.UserService;
import jakarta.annotation.PostConstruct;

@Service
public class UserServiceimpl implements UserService {
  
  @Override
  public User addUser(String name){
    return this.users.addUser(user);
  }

  
  private List<User> users = new ArrayList<>();
  User userA = new User(1,"Dorothy");
  User userB = new User(2,"John");
  users.add(userA);
  users.add(userB);
}
