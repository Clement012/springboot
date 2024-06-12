package com.example.sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.mapper.reqinmapper.CommentEntityMapper;
import com.example.sb.bc_forum.mapper.reqinmapper.PostEntityMapper;
import com.example.sb.bc_forum.mapper.reqinmapper.UserEntityMapper;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.repository.UserRepository;
import com.example.sb.bc_forum.service.UserService;

@Service
@Order(1)
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

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private PostServiceImpl postServiceImpl;

  @Autowired
  private CommentServiceImpl commentServiceImpl;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Override
  public List<User> getUsers()  {  //
    // String url = "https://jsonplaceholder.typicode.com/users";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(userEndpoint) //
        .toUriString(); //
    User[] users = restTemplate.getForObject(url, User[].class);
    return Arrays.asList(users);
  }

  public void saveUsers(){
   // if (userRepository == null){
   List<CommentEntity> commentEntity = commentServiceImpl.getComments().stream()
            .map(c -> commentEntityMapper.mapCommentEntity(c))
            .collect(Collectors.toList());
   List<PostEntity> postEntity = postServiceImpl.getPosts().stream()
           .map(p -> postEntityMapper.mapPostEntity(p, commentEntity))
            .collect(Collectors.toList());
      getUsers().stream()
      .map(u -> userEntityMapper.mapUserEntity(u , postEntity))
      .forEach(u -> userRepository.save(u));
   // }
   }

//   public UserEntity saveUserData(UserEntity userEntity) {
//     String url = "https://jsonplaceholder.typicode.com/users";
//     User[] users = restTemplate.getForObject(url, User[].class);

//     UserEntity entity = new UserEntity();
//     userRepository.save(entity);
// }
    
}
