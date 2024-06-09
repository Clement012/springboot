package com.bootcamp.sb.calculator.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.bootcamp.sb.calculator.model.Cat;
import com.bootcamp.sb.calculator.model.Color;

@Configuration // new AppConfig() -> Spring Context
public class AppConfig {

  public String sayHello(){
    return "hello";
  }

  @Bean(name = "white") // Create an object(bean) , and then put it into spring context
  // @Configuration ok / @Controller not ok
   Cat createWhiteCat(){
    return new Cat("Vincent", 4 , List.of(Color.WHITE) ); 
  } //actunamae ally no new in this case
  // new actually is DB data
  

  @Bean(name = "grey") //inject the object by bean name. //Approach2
  //@Primary //@Approach1 //first priority.
  Cat createGrayCat(){  
    return new Cat("Vera", 10,List.of(Color.GREY));
  }


}
