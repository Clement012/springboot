package demo.sb.restful.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import demo.sb.restful.entity.UserEntity;
import demo.sb.restful.repository.UserRepository;

@Component
public class AppRunner implements CommandLineRunner{
  
  // AppRunner bean already exists in Context after server start
  @Autowired
  private UserRepository userRepository;

  // run() will be executed by Spring before completed server start process
  @Override
  public void run(String... args){
    // if/else -> if not find -> server start failed.
    userRepository.save(new UserEntity()); // save and insert before server start.
    // System.out.println("hello");
    // throw new RunException 
  }
}
