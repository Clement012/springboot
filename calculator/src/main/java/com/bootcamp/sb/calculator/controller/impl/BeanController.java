package com.bootcamp.sb.calculator.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.CalculatorApplication;
import com.bootcamp.sb.calculator.controller.BeanOperation;

@Controller
@ResponseBody
public class BeanController implements BeanOperation {
  
  @Override
  public String[] getBeans(){
    return CalculatorApplication.getContext().getBeanDefinitionNames();
  }
}
