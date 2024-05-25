package com.bootcamp.sb.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  
  @GetMapping(value = "/beans")
  public String[] getBeans();
}
