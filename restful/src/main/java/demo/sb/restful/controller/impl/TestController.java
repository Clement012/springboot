package demo.sb.restful.controller.impl;

import java.util.List;
import org.springframework.stereotype.Controller;
import demo.sb.restful.model.dto.User;
import demo.sb.restful.service.UserService;

 // Spring vs Java difference
 // checked/ unchecked/ null
 // the way to manage the dependency
public class TestController {
  
  private UserService userService;
  
  public TestController(UserService userService)throws Exception{
    if (userService == null)
      throw new Exception();
    this.userService = userService;
  }

  public List<User> test(){
    return this.userService.getUsers();
  }

  public static void main(String[] args) {
    TestController testController = null;
    try {
      testController = new TestController(null);
    } catch (Exception e){
    }
    testController.test(); // NPE
  }
  
 
}
