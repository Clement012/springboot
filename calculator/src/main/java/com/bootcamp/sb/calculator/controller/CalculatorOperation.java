package com.bootcamp.sb.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
  
  @GetMapping(value = "/sum/{a}/{b}")
    public int sum(@PathVariable(value = "a") int salary,
      @PathVariable(value = "b") int bonus);

      @GetMapping(value = "/subtract/{salary}/{bonus}")
      public int subtract(@PathVariable int salary, @PathVariable int bonus);

      @GetMapping(value = "/multiply")
      public int multiply(@RequestParam(value = "a") int quantity,
      @RequestParam(value = "b") int price);

      @GetMapping(value = "/divide")
      public int divide(@RequestParam int quantity, @RequestParam int price);

      @GetMapping(value = "/sum/double")
      public double sum2(@RequestParam double p, @RequestParam double q);

      @GetMapping(value = "/sum2/String")
      public String sum3(@RequestParam String p, @RequestParam String q);


}
