package com.bootcamp.sb.calculator.controller;


import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sb.calculator.model.modeltest.CustomerList;


public interface CustomerOperation {
 
  @GetMapping("/customers/test")
  public CustomerList getList();
  
}
