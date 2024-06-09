package demo.sb.restful.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import demo.sb.restful.controller.PostOperation;
import demo.sb.restful.entity.PostEntity;
import demo.sb.restful.service.PostService;

@RestController
public class PostController implements PostOperation{

  @Autowired
  private PostService postService;
  
  @Override
  public PostEntity savePost(PostEntity post){
    return postService.savePost(post);
  }
}
