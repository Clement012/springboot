package com.example.sb.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto increment
  private Long id;
  private String name;
  @Column(name = "user_name")
  private String username;
  private String email;
  private String phone;
  private String website;
// private Address address;
  @Column(name = "addr_street")
  private String addrStreet;
  @Column(name = "addr_suite")
  private String addrSuite;
  @Column(name = "addr_city")
  private String addrCity;
  @Column(name = "addr_zipcode")
  private String addrZipcode;
//  private Geo geo;
  @Column(name = "addr_latitude")
  private String addrLatitude;  //lat
  @Column(name = "addr_Longtitude")
  private String addrLongtitude;  //lng
  // private Company company;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "company_catch_pharse")
  private String companyCatchPharse;
  @Column(name = "company_business")
  private String companyBusiness; //bs

  @OneToMany (cascade = {CascadeType.ALL})
  @JsonManagedReference
  @JoinColumn(name = "user_id")
  private List<PostEntity> posts = new ArrayList<>();
}
