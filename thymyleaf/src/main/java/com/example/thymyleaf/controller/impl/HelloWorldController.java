package com.example.thymyleaf.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.thymyleaf.controller.GreetingOperation;

//API 
@RestController // Controller + ResponseBody(JSON)
@RequestMapping(value = "v1")
public class HelloWorldController implements GreetingOperation{
  
  @Override
  public String hello(){
    return "on99";
  }
}
