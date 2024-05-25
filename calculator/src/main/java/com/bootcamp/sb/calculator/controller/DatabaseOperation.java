package com.bootcamp.sb.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DatabaseOperation {
  @GetMapping(value ="/database/value/{index}")
    public String get(@PathVariable String index);
    @GetMapping(value ="/database/sorting")
    public void sort();
}
