package com.example.sb.modelmapper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.sb.modelmapper.repository.UserRepository;

@Component
public class AppRunner implements CommandLineRunner{
  
  @Autowired
  private UserRepository userRepository;

  // Constructor DI

  @Override 
  public void run(String... args){

  }
}
