package demo.sb.restful.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import demo.sb.restful.dto.reqdto.UserReqDTO;
import demo.sb.restful.entity.UserEntity;
import demo.sb.restful.infra.NotFoundException;
import demo.sb.restful.infra.Scheme;
import demo.sb.restful.service.UserService;
import demo.sb.restful.model.dto.User;
import demo.sb.restful.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  
  // During the server start, bean creation process will consider @Value. 
  // Read the yml and inject value into the bean attribute
  @Value(value = "${api.json-place-holder.domain}") // required = true
  // Value -> 拆左上面組成既部份.
  private String domain;  // domain: 'jsonplaceholder.typicode.com'

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  // Spring will generate the class to implement the interface 
  @Autowired
  private UserRepository userRepository;

  @Override
  public List <User> getUsers(){    
    // RestTemplate
    // String url = "https://jsonplaceholder.typicode.com/users"
    
    String url = UriComponentsBuilder.newInstance() // rebulid to website
        .scheme(Scheme.HTTPS.lowerCase()) // http/https
        .host(this.domain)  // calling application.yml
        .path(userEndpoint) // last Sentence
        .toUriString();  // handle some // instead of String

    // System.out.println("url=" + url); check debug

    User[] users = restTemplate.getForObject(url, User[].class); 
    // new RestTemplate().getForObject
    // 1. call API,and get json result
    // 2. Convert json result to java object(User[].class)
    // call restful only need @getter
    // IN JAVA 
    return Arrays.asList(users);
  }
  @Override
  public UserEntity save(UserEntity user){
    return userRepository.save(user);
  }
  

  @Override
  public UserEntity deleteById(Long id){ 
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      userRepository.deleteById(id);
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
  public UserEntity getById(Long id){
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
  public UserEntity findByPhone(String phone){
    Optional<UserEntity> userEntity = userRepository.findByPhone(phone);
    if (userEntity.isPresent()){
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
  public List<UserEntity> findByAddrLatitudeAndAddrLongtitude(String addrLatitude,String addrLongtitude){
    Optional<List<UserEntity>> userEntity = 
         userRepository.findByAddrLatitudeAndAddrLongtitude(addrLatitude,addrLongtitude);
    if (userEntity.isPresent()){
      return userEntity.get();
    }
    throw new NotFoundException();
  }

  @Override
  public UserEntity updateUser(Long id,UserEntity entity){
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      userRepository.save(entity); // anyUpdateSave
      return entity;
    }
    throw new NotFoundException();
  }
      
  @Override
  public UserEntity updateEmailById(Long id, UserReqDTO dto){
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      UserEntity user = userEntity.get();  //select field 
      user.setEmail(dto.getEmail());  // update
      userRepository.save(user);  //save
      return user;
    }
    throw new NotFoundException();
  }

  // @Override
  // public List<UserEntity> getByAddrLatitudeGreaterThan(Double addrLatitude){
  //   Optional<List<UserEntity>> userEntities = userRepository.findByAddrLatitudeGreaterThan(addrLatitude);
  //   if (userEntities.isPresent()){
  //     return userEntities.get();
  //   }
  //   throw new NotFoundException();
  // }
}
