package com.example.sb.dto.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import com.example.sb.dto.model.Stock;
import com.example.sb.dto.model.User;
import jakarta.annotation.PostConstruct;

@Configuration
public class AppConfig {
  private final List<User> users = new ArrayList<>();

  public List<User> getUsers(){
    return this.users;
  }

  @PostConstruct
  public void addUsers(){
    User userA = new User();
    userA.add(new Stock(5, "ABC", 1000));
    User userB = new User();
    userB.add(new Stock(5, "ABC", 20000));
    User userC = new User();
    userC.add(new Stock(10, "DEV", 200));
    users.add(userA);
    users.add(userB);
    users.add(userC);
  }
  
}
