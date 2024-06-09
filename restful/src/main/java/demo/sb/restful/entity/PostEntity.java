package demo.sb.restful.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class PostEntity implements Serializable {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // primary
  private String title;
  private String body;

  // //private int user_Id;
  // related to case 2 // Directional relationship
  @ManyToOne
  @JoinColumn(name = "user_id") // DB table column nanme
  //JsonBackReference //end relationship
  private UserEntity user; //object
}
