package com.example.sb.bc_forum.mapper.reqinmapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqin.PostEntityDTO;
import com.example.sb.bc_forum.dto.reqin.UserEntityDTO;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.model.User;

@Component
public class UserEntityMapper {
  
  public UserEntity mapUserEntity(User user,List<PostEntity> postEntities){

   UserEntity userEntity = new UserEntity();
   userEntity.setId(Long.valueOf(user.getId()));
   userEntity.setName(user.getName());
   userEntity.setUsername(user.getUsername());
   userEntity.setEmail(user.getEmail());
   userEntity.setPhone(user.getPhone());
   userEntity.setWebsite(user.getWebsite());
   userEntity.setAddrStreet(user.getAddress().getStreet());
   userEntity.setAddrSuite(user.getAddress().getSuite());
   userEntity.setAddrCity(user.getAddress().getCity());
   userEntity.setAddrZipcode(user.getAddress().getZipcode());
   userEntity.setAddrLatitude(user.getAddress().getGeo().getLatitude());
   userEntity.setAddrLongtitude(user.getAddress().getGeo().getLongtitude());
   userEntity.setCompanyName(user.getCompany().getName());
   userEntity.setCompanyCatchPharse(user.getCompany().getCatchPhrase());
   userEntity.setCompanyBusiness(user.getCompany().getBusiness());
   userEntity.setPosts(postEntities);
   return userEntity;
  }
}
   
   