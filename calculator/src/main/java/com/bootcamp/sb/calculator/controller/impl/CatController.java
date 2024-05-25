package com.bootcamp.sb.calculator.controller.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.controller.CatOperation;
import com.bootcamp.sb.calculator.model.Cat;
import com.bootcamp.sb.calculator.model.Color;

@Controller
@ResponseBody
public class CatController implements CatOperation {
  
  // Java method returns Java object (Cat)
  // Spring Boot web layer(serialzation -from)
  @Override
  public Cat test(){
    return new Cat("ABC",13,List.of(Color.BLACK,Color.WHITE));
  }

  // in JSON List == Array

  // API return List<Cat>
  @Override
  public List<Cat> catTest(){
    return new ArrayList<>(List.of
    (new Cat("Vincent", 3, List.of(Color.GREY,Color.WHITE)),new Cat("Jason", 10,List.of(Color.BLUE))));
  }
  
  // API return Cat[]
  @Override
  public Cat[] catTest2(){
    return new Cat[]{new Cat("Vincent", 3,List.of(Color.GREY,Color.BLACK)),new Cat("Jason", 10,List.of(Color.BLUE,Color.WHITE))};
  }
}
