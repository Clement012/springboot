package demo.sb.restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import demo.sb.restful.controller.UserOperation;
import demo.sb.restful.dto.UserDTO;
import demo.sb.restful.mapper.UserMapper;
import demo.sb.restful.service.UserService;

@RestController
// RequestMapping(value = "/v1")
public class UserController implements UserOperation{

  @Autowired
  private UserService userService;

  @Autowired
  private UserMapper mapper;

  @Override
    public List<UserDTO> getUsers(){
    //  return userservice.getUsers(); // list in service
      return userService.getUsers().stream()
         .map(e -> mapper.map(e))
         .collect(Collectors.toList());
    };
}
