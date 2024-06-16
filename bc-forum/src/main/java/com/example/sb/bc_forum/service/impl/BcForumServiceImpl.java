package com.example.sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.bc_forum.exceptions.RestTemplateException;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.service.BcForumService;

@Service  //2
public class BcForumServiceImpl implements BcForumService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String userEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.posts}")
  private String postEndpoint;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<User> getUsers()  {  //
    // String url = "https://jsonplaceholder.typicode.com/users";
    
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(userEndpoint) //
        .toUriString(); //
    User[] users = restTemplate.getForObject(url, User[].class);
    if ( users != null ){
    return Arrays.asList(users);
    }throw new RestTemplateException();
    // return fetchData(userEndpoint, User[].class);

  }

  @Override  
  public List<Post> getPosts(int userId)  {
    // String url2 = "https://jsonplaceholder.typicode.com/posts";
    String url2 = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(postEndpoint) //
        .toUriString(); //
    Post[] posts = restTemplate.getForObject(url2, Post[].class);
    if (posts != null){
    return Arrays.stream(posts).filter(p -> p.getUserId() == userId)
           .collect(Collectors.toList());
    }throw new RestTemplateException();
    // return fetchData(postEndpoint, Post[].class);
  }

  @Override
  public List<Comment> getComments(int postId) {
    // String url3 = "https://jsonplaceholder.typicode.com/comments";
    String url3 = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(commentEndpoint) //
        .toUriString(); //
    Comment[] comments = restTemplate.getForObject(url3, Comment[].class);
    if (comments != null){
    return Arrays.stream(comments).filter(c -> c.getPostId() == postId)
            .collect(Collectors.toList());
    } throw new RestTemplateException();
    // return fetchData(commentEndpoint, Comment[].class);
  }
  
  // @Override
  // public void save(){
  //            getComments().stream()
  //           .map(c -> commentEntityMapper.mapCommentEntity(c))
  //           .forEach(c -> commentRepository.save(c))
  //           .collect(Collectors.toList());
  //  List<PostEntity> postEntity = postServiceImpl.getPosts().stream()
  //          .map(p -> postEntityMapper.mapPostEntity(p, commentEntity))
  //           .collect(Collectors.toList());
  //     getUsers().stream()
  //     .map(u -> userEntityMapper.mapUserEntity(u , postEntity))
  //     .forEach(u -> userRepository.save(u));
  // }
}
  
//private <T> List<T> fetchData(String endpoint, Class<T[]> responseType) {
  //   String url = UriComponentsBuilder.newInstance()
  //   .scheme("https")
  //   .host(this.domain)
  //   .path(endpoint)
  //   .toUriString();
  //   T[] response = restTemplate.getForObject(url, responseType);
  //   return Arrays.asList(response);
  //   }


// private String buildUrl(String endpoint) {
// return UriComponentsBuilder.newInstance()
// .scheme("https")
// .host(this.domain)
// .path(endpoint)
// .toUriString();
// }
// String url = buildUrl(userEndpoint);


 