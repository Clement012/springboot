package demo.sb.restful.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.sb.restful.entity.UserEntity;

@Repository // bean
// Hibernate
// Generate the class implementing this Jpa interface
public interface UserRepository extends JpaRepository<UserEntity,Long>{

  // JPA + Hibernate, generate corrsponding SQL syntax by method name convention
  // rules

  // select * from users where phone = ?
  Optional<UserEntity> findByPhone(String phone);

  // select * from users where addrLat = ? and addrLong = ?
  Optional<List<UserEntity>> findByAddrLatitudeAndAddrLongtitude(
       String addrLatitude,String addrLongtitude);

  // // JPQL (Java Persistence Query Language) -> work with Entity  //READ
  // @Query(value = "select e from UserEntity e where CAST(e.addrLatitude as double) > :lat")  //example
  // Optional<List<UserEntity>> findByAddrLatitudeGreaterThan(@Param(value = "lat") Double latitude);
 
  // // JPQL + @Modifying (Update, Delete)  //CREATE,UPDATE,DELETE
  // @Modifying  //Trans if A pay B get, B get but A no decrease <- reject
  // @Query(value = "update UseerEntity e set e.email = :newEmail where e.id = :userId")
  // void updateUserEmail(@Param("UserId") Long id,@Param("newEmail") String email);
  // // int /boolean//void?

  // order by?
  // like '%Lau%'
  //select specific fields?
  //group by? having?
  // max,min,sum,avg

}
