package demo.sb.restful.service;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import demo.sb.restful.dto.reqdto.UserReqDTO;
import demo.sb.restful.entity.UserEntity;
import demo.sb.restful.model.dto.User;

public interface UserService {
  List <User> getUsers()throws JsonProcessingException;

  UserEntity save(UserEntity user);

  UserEntity deleteById(Long id);

  UserEntity getById(Long id);

  UserEntity findByPhone(String phone);

  List<UserEntity> findByAddrLatitudeAndAddrLongtitude(String addrLatitude,String addrLongtitude);

  UserEntity updateUser(Long id,UserEntity entity);  // Put

  UserEntity updateEmailById (Long id, UserReqDTO dto);  //Patch

  //List<UserEntity> getByAddrLatitudeGreaterThan(Double addrLatitude);
} 