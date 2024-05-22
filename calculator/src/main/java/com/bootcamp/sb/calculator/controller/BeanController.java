package com.bootcamp.sb.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.CalculatorApplication;

@Controller
@ResponseBody
public class BeanController {
  
  @GetMapping(value = "/beans")
  public String[] getBeans(){
    return CalculatorApplication.getContext().getBeanDefinitionNames();
  }
}
