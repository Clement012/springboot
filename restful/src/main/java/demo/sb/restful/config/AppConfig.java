package demo.sb.restful.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import demo.sb.restful.infra.RedisHelper;
import demo.sb.restful.model.dto.User;

@Configuration
public class AppConfig {
  
  // WebClient
  @Bean
  RestTemplate restTemplate(){
    return new RestTemplate();
  }

  @Bean
  List<User> users(){
    return new ArrayList<>();
  }

  @Bean
   ObjectMapper objectMapper(){
    return new ObjectMapper();
   }
  
   // Difference between using RedisTemplate and RestTemplate
  // 1. You need to define the key, value types for RedisTemplate.class
  // 2. there are set() and get() method in redisTemplate object. You have to do
  // serialization and deserialization yourself.
  @Bean
   RedisHelper redisHelper(RedisConnectionFactory factory, ObjectMapper objectMapper){
    return new RedisHelper(factory , objectMapper);
   }
  }

