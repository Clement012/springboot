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
import com.example.sb.bc_forum.dto.reqin.CommentEntityDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.entity.UserEntity;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.mapper.reqinmapper.CommentEntityMapper;
import com.example.sb.bc_forum.mapper.reqinmapper.PostEntityMapper;
import com.example.sb.bc_forum.mapper.reqinmapper.UserEntityMapper;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.repository.CommentRepository;
import com.example.sb.bc_forum.service.CommentService;

@Service
@Order(3)
public class CommentServiceImpl implements CommentService {

  @Value(value = "${api.json-place-holder.domain}")
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.comments}")
  private String commentEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired 
  private CommentRepository commentRepository;

  @Autowired
  private CommentEntityMapper commentEntityMapper;

  // @Autowired
  // private PostServiceImpl postServiceImpl;

  // @Autowired
  // private PostEntityMapper postEntityMapper;

  // @Autowired
  // private UserServiceImpl userServiceImpl;

  // @Autowired
  // private UserEntityMapper userEntityMapper;

  @Override
  public List<Comment> getComments() {
    // String url3 = "https://jsonplaceholder.typicode.com/comments";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(commentEndpoint) //
        .toUriString(); //
    Comment[] comments = restTemplate.getForObject(url, Comment[].class);
    return Arrays.asList(comments);
    }

    @Override
    public void saveComments(){
       //if (commentRepository == null){

      //  UserEntity userEntity = userServiceImpl.getUsers().stream()
      //       .map(u -> userEntityMapper.mapUserEntity(u))
      //       .findFirst().orElseThrow(null);

      //  PostEntity postEntity = postServiceImpl.getPosts().stream()
      //       .map(p -> postEntityMapper.mapPostEntity(userEntity, p))
      //       .findFirst().orElseThrow(null);
       
        getComments().stream()
        .map(c -> commentEntityMapper.mapCommentEntity(c))
         .forEach(c -> commentRepository.save(c));
       //}
      }
    }
  //  public List<CommentEntityDTO> getCommentsToSave(){
  //   String url = UriComponentsBuilder.newInstance() //
  //   .scheme(Scheme.HTTPS.lowerCase()) //
  //   .host(this.domain) //
  //   .path(commentEndpoint) //
  //   .toUriString(); //
  //   Comment[] comments = restTemplate.getForObject(url, Comment[].class);
  //   List<CommentEntityDTO> ceo = Arrays.stream(comments)
  //      .map(e -> commentEntityMapper.mapCommentEntity(e))
  //      .collect(Collectors.toList());
  //      return ceo;
  //  }

  // public CommentEntity saveComment(CommentEntity comment){
  //   //"https://jsonplaceholder.typicode.com/comments"
  //   String url = UriComponentsBuilder.newInstance() //
  //       .scheme(Scheme.HTTPS.lowerCase()) //
  //       .host(this.domain) //
  //       .path(commentEndpoint) //
  //       .toUriString(); //
  //   Comment[] comments = restTemplate.getForObject(url, Comment[].class);
  //   Arrays.asList(comments);  //comments as Array
  //   CommentEntity cme = new CommentEntity();
  //    cme.setId(comment.getId());
  //    cme.setName(comment.getName());
  //    cme.setBody(comment.getBody());
  //    return commentRepository.save(cme);
  
  //   public void saveCommentData(String url) {
  //     String link = UriComponentsBuilder.newInstance() //
  //       .scheme(Scheme.HTTPS.lowerCase()) //
  //       .host(this.domain) //
  //       .path(commentEndpoint) //
  //       .toUriString(); //
  //   Comment[] comments = restTemplate.getForObject(link, Comment[].class);
  //     Arrays.asList(comments);

  //     commentRepository.save(comments);
  // }
  
  // String url = UriComponentsBuilder.newInstance() //
  //       .scheme(Scheme.HTTPS.lowerCase()) //
  //       .host(this.domain) //
  //       .path(commentEndpoint) //
  //       .toUriString(); //
  //   Comment[] comments = restTemplate.getForObject(url, Comment[].class);
  //   CommentEntity cme = new CommentEntity();
  //    cme.setId(comment.getId());
  //    cme.setName(comment.getName());
  //    cme.setBody(comment.getBody());
  //    return commentRepository.save(cme);
  //   }
