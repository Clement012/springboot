package com.bootcamp.sb.demosbhelloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/sg")
public class SgHelloWorldController {

  @GetMapping(value = "/hellohello")  //URI -> resource identifier
  public String hello(){
    return "Hello World/Hello World";
  }
  @GetMapping(value = "/goodbyegoodbye")  //URI -> resource identifier
  public String hello2(){
    return "Goodbye/Goodbye";
  }
  
}
