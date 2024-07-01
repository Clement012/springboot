package com.bootcamp.sb.demosbhelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/hk")
public class HkHelloWorldController {

  // API 接口 (Application Programming Interface)
  @GetMapping(value = "/hello")  //URI -> resource identifier
  public String hello(){
    return "Hello World";
  }
  @GetMapping(value = "/goodbye")  //URI -> resource identifier
  public String hello2(){
    return "Goodbye";
  }
  public static void main(String[] args) {  
    HkHelloWorldController hc = new HkHelloWorldController();
    System.out.println(hc.hello());
  }
}
