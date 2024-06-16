package demo.sb.restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.management.RuntimeErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import demo.sb.restful.controller.UserOperation;
import demo.sb.restful.dto.reqdto.UserReqDTO;
import demo.sb.restful.dto.respdto.UserDTO;
import demo.sb.restful.entity.UserEntity;
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
    public List<UserDTO> getUsers() throws JsonProcessingException {
    //  return userservice.getUsers(); // list in service
      return userService.getUsers().stream()
         .map(e -> mapper.map(e))
         .collect(Collectors.toList());
    };

  @Override
   public UserEntity saveUser(UserEntity user){
  //  if (user.getAddrCity() == null)
  //    throw new RuntimeErrorException(); // GlobalExceptionHandler
    return userService.save(user);
   }


  @Override
  public UserEntity deleteUser(Long id){
    return userService.deleteById(id);
  }

  @Override
  public UserEntity getUsers(Long id){
    return userService.getById(id);
  }

  // Get User By Phone;
  @Override
  public UserEntity findUsersByPhone(String phone){
    return userService.findByPhone(phone);
  }

  // Get User By Lat/Long;
  @Override
  public List<UserEntity> findUsersByLatLong(String addrLatitude,String addrLongtitude){
   return userService.findByAddrLatitudeAndAddrLongtitude(addrLatitude,addrLongtitude);
  }

  @Override  //putMapping
  public UserEntity updateUser(Long id,UserEntity entity){
    return userService.updateUser(id, entity);
  }

  @Override  //patchmapping
  public UserEntity updateEmailById(Long id, UserReqDTO dto){
    return userService.updateEmailById(id, dto);
  }
}
// Change DTO
// Controller do Handling usually 
