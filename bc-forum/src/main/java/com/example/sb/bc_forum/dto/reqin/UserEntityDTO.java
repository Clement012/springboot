package com.example.sb.bc_forum.dto.reqin;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserEntityDTO {
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String addrStreet;
  private String addrSuite;
  private String addrCity;
  private String addrZipcode;
  private String addrLatitude;  //lat
  private String addrLongtitude;  //lng
  private String companyName;
  private String companyCatchPharse;
  private String companyBusiness; //bs
  private List<PostEntityDTO> posts;
}
