package demo.sb.restful.mapper;

import org.springframework.stereotype.Component;
import demo.sb.restful.dto.respdto.UserDTO;
import demo.sb.restful.dto.respdto.UserDTO.AddressDTO;
import demo.sb.restful.dto.respdto.UserDTO.CompanyDTO;
import demo.sb.restful.dto.respdto.UserDTO.AddressDTO.GeoDTO;
import demo.sb.restful.model.dto.User;

@Component
public class UserMapper {

   // UserDTO -> User(model) -> UserEntity(DB)  (Model in service do Calculation)
   // OtherUserDTO -> User(model) -> AnotherUserDTO -> Call other API
  
  public UserDTO map(User user){  //
    GeoDTO geoDTO = GeoDTO.builder()
       .latitude(user.getAddress().getGeo().getLatitude())
       .longtitude(user.getAddress().getGeo().getLongtitude())
       .build();
    
    AddressDTO addressDTO = AddressDTO.builder()
       .street(user.getAddress().getStreet())
       .suite(user.getAddress().getSuite())
       .city(user.getAddress().getCity())
       .geo(geoDTO)
       .build();

    CompanyDTO companyDTO = CompanyDTO.builder()
       .name(user.getCompany().getName())
       .buniness(user.getCompany().getBusiness())
       .build();

      return UserDTO.builder()
         .id(user.getId())
         .name(user.getName())
         .address(addressDTO)
         .company(companyDTO)
         .build();
  }
}
