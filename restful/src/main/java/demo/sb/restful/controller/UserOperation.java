package demo.sb.restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import demo.sb.restful.dto.reqdto.UserReqDTO;
import demo.sb.restful.dto.respdto.UserDTO;
import demo.sb.restful.entity.UserEntity;

public interface UserOperation {
  
  @GetMapping(value = "/jsonplacefolder/users")
  List<UserDTO> getUsers() throws JsonProcessingException;

  @PostMapping(value = "/user")
  UserEntity saveUser(@RequestBody UserEntity user);

  @DeleteMapping(value = "/user")
  UserEntity deleteUser(@RequestParam Long id);

  // Similar to SQL "update users where id = ?"
  // if id exists, update the user, and return the updated user object.
  // if id not exists, update nothing, return NotFoundException

  // Get User By Id;
  @GetMapping(value = "/usergetbyid")
  UserEntity getUsers(@RequestParam Long id);

  // Get User By Phone;
  @GetMapping(value = "/usergetbyphone")
  UserEntity findUsersByPhone(@RequestParam String phone);

  // Get User By Lat/Long;
  @GetMapping(value = "/usergetbylatlong")
  List<UserEntity> findUsersByLatLong(@RequestParam String addrLatitude,
     @RequestParam String addrLongtitude);

  @PutMapping(value = "/user/update") // update ALL by field
  UserEntity updateUser(@RequestParam Long id, @RequestBody UserEntity entity);

  @PatchMapping(value = "/user/email") // update by field 
  UserEntity updateEmailById(@RequestParam Long id,@RequestBody UserReqDTO dto);
  // ResquestBody: getAll 
  // Use same as Post

  //GetMapping(value = )
  
}
