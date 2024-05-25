package com.bootcamp.sb.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.model.Cat;
@Controller
@ResponseBody
public interface TestOperation {
  
  @GetMapping(value = "/hello")
  public String sayHello();

  @GetMapping(value = "/hello2")
  public String sayHello2();

  @GetMapping(value = "/catcat")
  public Cat createWhiteCat();

}
