package com.example.thymyleaf.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface GreetingOperation {
  
  @GetMapping(value = "/hello")
  String hello();
}
