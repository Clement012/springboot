package demo.sb.restful.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import demo.sb.restful.entity.PostEntity;

public interface PostOperation {
  
  @PostMapping(value = "/post")
  PostEntity savePost(@RequestBody PostEntity post);
}
