package demo.sb.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.sb.restful.entity.PostEntity;
import demo.sb.restful.repository.PostRepository;
import demo.sb.restful.service.PostService;

@Service
public class PostServiceimpl implements PostService {

  @Autowired
  private PostRepository postRepository;
  
  @Override
  public PostEntity savePost(PostEntity post){
    return postRepository.save(post);
  }
}
