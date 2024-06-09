package com.example.sb.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO;


public interface BcForumOperation {

  //3a
  @GetMapping(value = "/users/all")  
  List<UserDTO> getAllById(); 

  // 3b
  @GetMapping(value = "/users/comment")
  ForumUserDTO getForumData(@RequestParam int id);

} 