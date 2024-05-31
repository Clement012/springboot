package demo.sb.restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import demo.sb.restful.dto.UserDTO;

public interface UserOperation {
  
  @GetMapping(value = "/jsonplacefolder/users")
  List<UserDTO> getUsers();
}
