package com.bootcamp.sb.calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.sb.calculator.config.AppConfig;
import com.bootcamp.sb.calculator.controller.TestOperation;
import com.bootcamp.sb.calculator.model.Cat;

@Controller
@ResponseBody
public class TestController implements TestOperation{

  @Autowired  // Find the appConfig object(bean) from spring context, and then
  // protect the server with after scanning @Controller, @Service, @Repository, @Configuration then START the server normally.
  // default Autowired is true.
  // if (required = false) -> can use appConfig but cant point to sayHello() method
  private AppConfig appConfig; 

  @Autowired 
  private AppConfig appConfig2;

  @Autowired
  @Qualifier(value = "grey") //inject the object by bean name.
  private Cat cat;

  @Override
  public String sayHello(){
    // local object (new AppConfig())
    return new AppConfig().sayHello();
  }  // Why need new?
  // Why no need new?

  @Override
  public String sayHello2(){
    return appConfig.sayHello(); //NPE if @Autowired(required = false)
 /*   if (appConfig == appConfig2)
   return "Yes";  //Yes
   return "No";  */
  }

  @Override
  public Cat createWhiteCat(){
    return this.cat;
  }

}
// What is bean?
// How @Configuration work?
// How SpringBoot run?
// @Compoent?
// @Autowired? 

// recite CalculatorApplication syntax -> check bean

// Is this class--
// Why have to new?
// Why use private Cat cat?
// 
