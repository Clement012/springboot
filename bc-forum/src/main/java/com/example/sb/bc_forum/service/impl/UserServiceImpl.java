package com.example.sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.exceptions.NotFoundException;
import com.example.sb.bc_forum.exceptions.RestTemplateException;
import com.example.sb.bc_forum.exceptions.UserNotFoundException;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.mapper.reqinmapper.UserEntityMapper;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.repository.UserRepository;
import com.example.sb.bc_forum.service.UserService;

@Service
//Order(1)
public class UserServiceImpl implements UserService {
  
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired 
  private UserRepository userRepository;

  @Autowired
  private UserEntityMapper userEntityMapper;

  @Override
  public List<User> getUsers()  {  //
    // String url = "https://jsonplaceholder.typicode.com/users";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(userEndpoint) //
        .toUriString(); //
    User[] users = restTemplate.getForObject(url, User[].class);
    if (users != null){
    return Arrays.asList(users);
    } throw new RestTemplateException();
  }

  @Override
  public void saveUsers(){
  //  if (userRepository == null){
      getUsers().stream()
      .map(u -> userEntityMapper.mapUserEntity(u))
      .forEach(u -> userRepository.save(u));
    // }
   }

   @Override
   public List<UserEntity> getUserEntities(){
    return userRepository.findAll();
   }

   @Override
   public UserEntity getUserById(Long id){
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      return userEntity.get();
    }
    throw new UserNotFoundException();
   }
   @Override
   public UserEntity updateUser(Long id,UserEntity entity){
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity.isPresent()){
      userRepository.save(entity);
      return entity;
    }
    throw new UserNotFoundException();
    }
   }

