package com.example.thymyleaf.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.thymyleaf.controller.GreetingOperation;

// Thymeleaf:
// 1.Server Side Rendering
// 2.
// Return html
@Controller
public class ABCViewController {

  @Autowired
  private GreetingOperation greetingOperation;
  
  @GetMapping(value = "/abc")
  public String abc(Model model){
    model.addAttribute("message", greetingOperation.hello());
    return "abc"; // abc.html
  }
}
