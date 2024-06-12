package demo.sb.restful.entity;

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
import lombok.Getter;
import lombok.Setter;

// @Entity
// JPA will generate the DDL (create Table) bt the definition in Entity Class
@Getter
@Setter
@Entity
@Table(name = "Users")
public class UserEntity {
  
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
  @Column(name = "company_Name")
  private String companyName;
  @Column(name = "company_catch_pharse")
  private String companyCatchPharse;
  @Column(name = "company_business")
  private String companyBusiness; //bs
  
  // // case 1 undirectional relationship
  // // only add at user
  // @OneToMany (cascade = {CascadeType.ALL})    
  // @JoinColumn(name = "user_id")
  // private List<PostEntity> posts = new ArrayList<>();

  //case 2 //-> use JsonManagedReference to connect with with postEntity
  @OneToMany (cascade = CascadeType.ALL)  // cascade : insert 
  //JsonManagedReference
  //JoinColumn(name = "user_id")
  private List<PostEntity> posts = new ArrayList<>();

  //Cascade:
}

