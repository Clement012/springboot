package demo.sb.restful.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import demo.sb.restful.infra.Scheme;
import demo.sb.restful.service.UserService;
import demo.sb.restful.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
  
  // During the server start, bean creation process will consider @Value. 
  // Read the yml and inject value into the bean attribute
  @Value(value = "${api.json-place-holder.domain}") // required = true
  // Value -> 拆左上面組成既部份.
  private String domain;  // domain: 'jsonplaceholder.typicode.com'

  @Value(value = "${api.json-place-holder.endpoints.users}")
  private String userEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List <User> getUsers(){    
    // RestTemplate
    // String url = "https://jsonplaceholder.typicode.com/users"
    
    String url = UriComponentsBuilder.newInstance() // rebulid to website
        .scheme(Scheme.HTTPS.lowerCase()) // http/https
        .host(this.domain)  // calling application.yml
        .path(userEndpoint) // last Sentence
        .toUriString();  // handle some // instead of String

    // System.out.println("url=" + url); check debug

    User[] users = restTemplate.getForObject(url, User[].class); 
    // new RestTemplate().getForObject
    // 1. call API,and get json result
    // 2. Convert json result to java object(User[].class)
    // call restful only need @getter
    // IN JAVA 
    return Arrays.asList(users);
  }
}
