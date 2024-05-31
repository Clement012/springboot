package demo.sb.restful.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor  // detect noargs first
@AllArgsConstructor
@Builder
public class UserDTO {
  private int id;
  private String name;
  // private String username;
 // private String email;
  private AddressDTO address;
 // private String phone;
 // private String website;
  private CompanyDTO company;

  @Getter
  @Builder
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
  //  private String zipcode;
    private GeoDTO geo;
    

    @Getter
    @Builder
   public static class GeoDTO {
     private String latitude;
     private String longtitude;
   }
  }
  @Getter
  @Builder
  public static class CompanyDTO {
    private String name;
  //  private String catchPharse;
    @JsonProperty(value = "bs")
    private String buniness;
   }
}
