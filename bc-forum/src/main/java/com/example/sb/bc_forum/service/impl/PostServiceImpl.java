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
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.repository.PostRepository;
import com.example.sb.bc_forum.service.PostService;

@Service
@Order(2)
public class PostServiceImpl implements PostService{
  
  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired 
  private PostRepository postRepository;

  @Autowired
  private PostEntityMapper postEntityMapper;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  @Autowired
  private CommentServiceImpl commentServiceImpl;

  @Override  
  public List<Post> getPosts()  {
    // String url2 = "https://jsonplaceholder.typicode.com/posts";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(postEndpoint) //
        .toUriString(); //
    Post[] posts = restTemplate.getForObject(url, Post[].class);
    return Arrays.asList(posts);
    // return fetchData(postEndpoint, Post[].class);
  }

  @Override
  public void savePosts(){
    //if (postRepository == null){
      List<CommentEntity> commentEntity = commentServiceImpl.getComments().stream()
            .map(c -> commentEntityMapper.mapCommentEntity(c))
            .collect(Collectors.toList());
              getPosts().stream()
               .map(post -> postEntityMapper.mapPostEntity(post, commentEntity))
               .forEach(post -> postRepository.save(post));
      // List <UserEntity> userEntities = userServiceImpl.getUsers().stream()
      //    .map(u -> { // input userEntity
      // List<PostEntity> postEntities = getPosts().stream()
      // .map(post -> postEntityMapper.mapPostEntity(u , post))
      // .forEach(post -> postRepository.save(post));
      //  return userEntityMapper(u);
      //    }).forEach(user -> userRepository.save(user));
      
    //}
   }
  
}
