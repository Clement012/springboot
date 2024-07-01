package com.example.thymyleaf.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.thymyleaf.model.Post;

@Service
public class PostService {

  @Autowired
  private RestTemplate restTemplate;

  public List<Post> getPost(){
    String url = "https://jsonplaceholder.typicode.com/posts";
    Post[] response = restTemplate.getForObject(url, Post[].class);
    return Arrays.asList(response);
  }
}
