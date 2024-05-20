package com.bootcamp.sb.demosbhelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloWorldController {

  // API 接口 (Application Programming Interface)
  @GetMapping(value = "/hello")  //URI -> resource identifier
  public String hello(){
    return "Hello World";
  }
  @GetMapping(value = "/hi")  //URI -> resource identifier
  public String hello2(){
    return "Hi";
  }
  public static void main(String[] args) {  
    HelloWorldController hc = new HelloWorldController();
    System.out.println(hc.hello());
  }
}
