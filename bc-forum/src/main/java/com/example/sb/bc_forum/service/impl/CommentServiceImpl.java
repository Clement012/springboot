package com.example.sb.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import com.example.sb.bc_forum.dto.reqout.CommentReqDTO;
import com.example.sb.bc_forum.entity.CommentEntity;
import com.example.sb.bc_forum.entity.PostEntity;
import com.example.sb.bc_forum.exceptions.NotFoundException;
import com.example.sb.bc_forum.exceptions.RestTemplateException;
import com.example.sb.bc_forum.infra.Scheme;
import com.example.sb.bc_forum.mapper.reqinmapper.CommentEntityMapper;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.repository.CommentRepository;
import com.example.sb.bc_forum.service.CommentService;
@Service
//Order(3)
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



  @Override
  public List<Comment> getComments()  {
    // String url3 = "https://jsonplaceholder.typicode.com/comments";
    String url = UriComponentsBuilder.newInstance() //
        .scheme(Scheme.HTTPS.lowerCase()) //
        .host(this.domain) //
        .path(commentEndpoint) //
        .toUriString(); //
    Comment[] comments = restTemplate.getForObject(url, Comment[].class);
     if (comments != null){
     return Arrays.asList(comments);
     } throw new RestTemplateException();
    }

    @Override
    public void saveComments(){

       getComments().stream()
       .map(c -> commentEntityMapper.mapCommentEntity(c))
       .forEach(c -> commentRepository.save(c));
  
  } 
    @Override
    public List <CommentEntity> getCommentEntities(){
      return commentRepository.findAll();
    }
    
    @Override
    public List <CommentEntity> getByPostId(Long postId){
      PostEntity postEntity = new PostEntity();
      postEntity.setId(postId);
      List<CommentEntity> commentEntity = commentRepository.findByPostId(postEntity);
      if (commentEntity.size() > 0){
        return commentEntity;
      }
      throw new NotFoundException();
    }

    @Override
    public CommentEntity addByPostId(Long postId,CommentEntity entity){
      PostEntity postEntity = new PostEntity();
      postEntity.setId(postId);
      List<CommentEntity> commentEntity = commentRepository.findByPostId(postEntity);
      if (commentEntity.size() > 0){
         entity.setPost(postEntity);
         commentRepository.save(entity);
       return entity;
     }
     throw new NotFoundException();
    }

    @Override 
    public CommentEntity updateComment(Long id,CommentReqDTO dto){
      Optional<CommentEntity> commentEntity = commentRepository.findById(id);
      if (commentEntity.isPresent()){
        CommentEntity comment = commentEntity.get();
        comment.setName(dto.getName());
        comment.setId(dto.getId());
        comment.setBody(dto.getBody());
        comment.setEmail(dto.getEmail());
        commentRepository.save(comment);
        return comment;
      }
      throw new NotFoundException();
    }
}   
      //  }
      
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

  // // List<UserEntity> userEntities = userService.getUsers().stream()
  //     // .map(u -> userEntityMapper.mapUserEntity(u))
  //     // .collect(Collectors.toList());
      
  //     // for (UserEntity userEntity : userEntities){
  //     // List<PostEntity> postEntities = postService.getPosts(userEntity.getId()).stream()
  //     // .map(p -> postEntityMapper.mapPostEntity(userEntity, p))
  //     // .collect(Collectors.toList());
      
  // // for (PostEntity postEntity : postEntities) {
  // //  List<CommentEntity> commentEntities =
  // getComments().stream()
  // //  .filter(c -> c.getPostId() == postEntity.getId())
  //  .map(c -> commentEntityMapper.mapCommentEntity(c))
  //  .forEach(c -> commentRepository.save(c));
  // //  .collect(Collectors.toList());
  // //  commentRepository.saveAll(commentEntities);
