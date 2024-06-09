package com.example.sb.bc_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.sb.bc_forum.dto.reqout.UserDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.AddressDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.CompanyDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.AddressDTO.GeoDTO;
import com.example.sb.bc_forum.model.User;

@Component
public class UserMapper {

   public UserDTO mapUser(User user,List <PostDTO> posts){  //List<Comment> comments
    
      GeoDTO geoDTO = GeoDTO.builder()
      .latitude(user.getAddress().getGeo().getLatitude())
      .longtitude(user.getAddress().getGeo().getLongtitude())
      .build();
   
   AddressDTO addressDTO = AddressDTO.builder()
      .street(user.getAddress().getStreet())
      .suite(user.getAddress().getSuite())
      .city(user.getAddress().getCity())
      .zipcode(user.getAddress().getZipcode())
      .geo(geoDTO)
      .build();
   
   CompanyDTO companyDTO = CompanyDTO.builder()
      .name(user.getCompany().getName())
      .catchPhrase(user.getCompany().getCatchPhrase())
      .business(user.getCompany().getBusiness())
      .build();

      return UserDTO.builder()
         .id(user.getId())
         .name(user.getName())
         .username(user.getUsername())
         .email(user.getEmail())
         .address(addressDTO)
         .phone(user.getPhone())
         .website(user.getWebsite())
         .company(companyDTO)
         .posts(posts) //
         .build();
    }
   } 
  
