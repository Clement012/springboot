package com.example.sb.bc_forum.dto.reqout;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  private int id;
  private String name;
  private String username;
  private String email;
  private AddressDTO address;
  private String phone;
  private String website;
  private CompanyDTO company;
  private List<PostDTO> posts;

  @Getter
  @Builder
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;
    
    @Getter
    @Builder
   public static class GeoDTO {
     @JsonProperty(value = "lat")
     private String latitude;
     @JsonProperty(value = "lng")
     private String longtitude;
   }
  }
  @Getter
  @Builder
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    @JsonProperty(value = "bs")
    private String business;
   }
   
  @Getter
  @Builder
  public static class PostDTO {
  private int userId;
  private int id;
  private String title;
  private String body;
  private List<CommentDTO> comments;
  @Getter
  @Builder
  public static class CommentDTO {
    private int postId;  // = post.class id;
    private int id;
    private String name;
    private String email;
    private String body; 
   }
  }
}