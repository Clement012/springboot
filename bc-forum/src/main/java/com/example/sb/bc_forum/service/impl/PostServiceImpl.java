package com.example.sb.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.exceptions.NotFoundException;
import com.example.sb.bc_forum.exceptions.RestTemplateException;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.mapper.reqinmapper.PostEntityMapper;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.repository.PostRepository;
import com.example.sb.bc_forum.service.PostService;

@Service
//Order(2)
public class PostServiceImpl implements PostService{
  
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private PostRepository postRepository;

  @Override  
  public List<Post> getPosts()  {
    // String url2 = "https://jsonplaceholder.typicode.com/posts";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(postEndpoint) //
        .toUriString(); //
    Post[] posts = restTemplate.getForObject(url, Post[].class);
    if (posts != null){
      return Arrays.asList(posts);
    }
    throw new RestTemplateException();
    // return fetchData(postEndpoint, Post[].class);
  }

  @Override
  public void savePosts(){
    // if (postRepository == null){  

      // List<UserEntity> userEntities = userService.getUsers().stream()
      //                     .map(u -> userEntityMapper.mapUserEntity(u))
      //                     .collect(Collectors.toList());

    //for (UserEntity userEntity : userEntities) {  
    //List<PostEntity> postEntities =  userEntity.getId()
                            getPosts().stream()
                           .map(post -> postEntityMapper.mapPostEntity(post))
                           .forEach(p -> postRepository.save(p));
                     //      .collect(Collectors.toList());
       //  postRepository.saveAll(postEntities);
     } 
   
   
   @Override
   public List<PostEntity> getPostEntities(){
    return postRepository.findAll();
   }

   @Override
   public List<PostEntity> getPostByUserId(Long userId){
     UserEntity userEntity = new UserEntity();
     userEntity.setId(userId);
     List<PostEntity> postEntity = postRepository.findByUserId(userEntity);
    if (postEntity.size() > 0){
      return postEntity;
    }
      throw new NotFoundException();
   }

   @Override 
   public PostEntity addPost(Long userId,PostEntity entity){
    UserEntity userEntity = new UserEntity();
    userEntity.setId(userId);
    List<PostEntity> postEntity = postRepository.findByUserId(userEntity);
   if (postEntity.size() > 0){
    entity.setUser(userEntity);
    postRepository.save(entity);
    return entity;
     }
     throw new NotFoundException();
   }

   @Override
   public PostEntity deletePostById(Long id){
    Optional<PostEntity> postEntity = postRepository.findById(id);
    if (postEntity.isPresent()){
      postRepository.deleteById(id);
      return postEntity.get();
    }
    throw new NotFoundException();
   }
  }

