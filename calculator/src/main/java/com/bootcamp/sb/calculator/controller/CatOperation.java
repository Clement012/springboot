package com.bootcamp.sb.calculator.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sb.calculator.model.Cat;

public interface CatOperation {
  @GetMapping(value = "/cat/test")
  public Cat test();

  @GetMapping(value = "/cats/listtest")
  public List<Cat> catTest();

  @GetMapping(value = "/catss/arraytest")
  public Cat[] catTest2();
}
