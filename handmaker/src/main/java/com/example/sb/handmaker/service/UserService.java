package com.example.sb.handmaker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.sb.handmaker.model.User;
import jakarta.annotation.PostConstruct;

public interface UserService {

  public Optional<User> getUser(String name);
  
  public User addUser(String name);

  
}