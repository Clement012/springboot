package com.example.sb.bc_forum.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.bc_forum.controller.BcForumOperation;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO;
import com.example.sb.bc_forum.dto.reqout.ForumUserDTO.ForumCommentDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO;
import com.example.sb.bc_forum.dto.reqout.UserDTO.PostDTO.CommentDTO;

import com.example.sb.bc_forum.mapper.CommentMapper;
import com.example.sb.bc_forum.mapper.ForumCommentMapper;
import com.example.sb.bc_forum.mapper.ForumUserMapper;
import com.example.sb.bc_forum.mapper.PostMapper;
import com.example.sb.bc_forum.mapper.UserMapper;
import com.example.sb.bc_forum.model.Comment;
import com.example.sb.bc_forum.model.Post;
import com.example.sb.bc_forum.model.User;
import com.example.sb.bc_forum.service.BcForumService;


@RestController
public class BcForumController implements BcForumOperation{
  
  @Autowired
  private BcForumService bcForumService;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private CommentMapper commentMapper;

  @Autowired 
  private ForumUserMapper forumUserMapper;

  @Autowired
  private ForumCommentMapper forumCommentMapper;

  @Override //2-3a
  public List<UserDTO> getAllById() { // = post.class ->userId
    List <User> users = bcForumService.getUsers();

    List<UserDTO> userDTOs = users.stream() //
    // .filter(u -> u.getId() == id)
    .map(user->{//
      List<PostDTO> postsList = bcForumService.getPosts(user.getId()).stream() //
        .map(post ->{//
        List<CommentDTO> commentsList = bcForumService.getComments(post.getId()).stream()//
          .map(c -> commentMapper.mapComment(c))
          .collect(Collectors.toList());//
            
          return postMapper.mapPost(post, commentsList);
        }).collect(Collectors.toList());

      return userMapper.mapUser(user, postsList);
    }).collect(Collectors.toList());
   
      return userDTOs;
  }

  @Override //2-3b
  public ForumUserDTO getForumData(int id) {  
    User user = bcForumService.getUsers().stream()
        .filter(u -> u.getId() == id)
        .findFirst().orElse(null);  //get user ById
    List<Post> posts = bcForumService.getPosts(id);  //get posts by userId
    List<Comment> comments = bcForumService.getComments(id).stream()  // bug 
        .filter(c -> posts.stream()
           .anyMatch(p -> p.getId() == c.getPostId()))
        .collect(Collectors.toList());
        
    List<ForumCommentDTO> commentsList = comments.stream()
        .map(c -> forumCommentMapper.mapForumCommentDTO(c)) //
        .collect(Collectors.toList());//

   return forumUserMapper.mapForumUser(user, commentsList);
  }

  }




//3a forEach fail
//List<Comment> comments = this.getComments().stream()
      // .filter(e -> e.getPostId() == 1)
      // .map(e -> commentMapper.map(e))
      // .collect(Collectors.toList());
   // List<Post> posts = this.getPosts().stream() //get post by user id
      // .filter(e -> e.getUserId() == userID)
      // .map(e -> postMapper.map(e, comments))      
      // .collect(Collectors.toList());
   //  List<User> users = this.getUsers().stream()
      // // .filter(e -> e.getId() == userID)
      // .map(e -> userMapper.map(e, posts))
      // .collect(Collectors.toList());
      //
  //     List<UserDTO> userDTOsFinal = new ArrayList<>();
  //      for(UserDTO u : users){ 
  //        if(u.getId()==userID){
  //         for(PostDTO p : posts){
  //          if(p.getUserId() == userID){
  //           for(CommentDTO c : comments){
  //             if(c.getPostId() == p.getId())
  //             p.getComments().add(c); //error With wrong type? ConcurrentModificationException
  //           }
  //         }
  //         posts.add(p);
  //       }
  //     }
  //     userDTOsFinal.add(u);
  //   }
  //   return userDTOsFinal;
  // }
      // List<CommentDTO> commentDTOs = new ArrayList<>();
      //     for(CommentDTO c : comments){
      //        commentDTOs.add(c); // Error
      //      } 
      // List<PostDTO> postList = this.getPosts().stream()
      //      .map(e -> postMapper.map(e, commentDTOs))
      //      .collect(Collectors.toList());
      // List<PostDTO> postDTOs = new ArrayList<>();
      //     for(PostDTO p : postList){
      //       if(p.getId() == userID){
      //         // for(CommentDTO c : comments){
      //         //   p.getComments().add(c); // Error
      //       //} 
      //        postDTOs.add(p);
      //     }
      //   }
      // List<UserDTO> userDTOs = this.getUsers().stream()
      //    .map(e -> userMapper.map(e, postDTOs))
      //    .collect(Collectors.toList());
      // List<UserDTO> userDTOsFinal = new ArrayList<>();
      //      for (UserDTO u : userDTOs){
      //       if (u.getId() == userID){
      //         userDTOsFinal.add(u);
      //       }
      //      } 
      //     return userDTOsFinal;
      // }
      
// List<User> users = this.getUsers();
      // List<Post> posts = this.getPosts();
      // List<Comment> comments = this.getComments();
      // List<CommentDTO> commentDTO = comments.stream()
      //      .map(e -> commentMapper.map(e))
      //      .collect(Collectors.toList());

      // List<PostDTO> postFinal = posts.stream()
      //      .map(e -> postMapper.map(e, commentDTO))
      //      .collect(Collectors.toList());
      
      // List<User> userChange = new ArrayList<>();
      // List<Post> postChange = new ArrayList<>();
      // List<Comment> commentChange = new ArrayList<>();
            
      //   //  for (User u : users){
      //   //     if (u.getId() == userID){
      //   //       userChange.add(u);
      //   //     }
      //   //   }
              
      //   //   for(Post p : posts){
      //   //     if(p.getUserId() == userID){
      //   //       for(Comment c : comments){
      //   //         if (c.getPostId() == p.getId()) //&& p.getUserId() == userID
      //   //         commentChange.add(c); 
      //   //       }
      //   //       postChange.add(p);
      //   //   }
      //   // }
       
      //     // for(Comment c : comments){
      //     //  if (c.getPostId() <=  ) // logic <-
      //     //   commentChange.add(c); 
      //     //   } 
       
      //  List<PostDTO> postFinal = postChange.stream()
      //      .map(e -> postMapper.map(e, commentDTO))
      //      .collect(Collectors.toList());
      //  List<UserDTO> userDTOsFinal = userChange.stream()
      //      .map(e -> userMapper.map(e, postFinal))
      //      .collect(Collectors.toList());
      //  return userDTOsFinal;