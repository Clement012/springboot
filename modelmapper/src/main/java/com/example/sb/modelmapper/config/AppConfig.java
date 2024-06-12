package com.example.sb.modelmapper.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  
  @Bean
  ModelMapper modelmapper(){
    return new ModelMapper();
  }
  // model map left modelMapper.map(input, AfterDTO.class)
  // have to use setter/getter for object mapping
  // DTO & Mapper (Per Consumer)
  // MapSrtuct Mapper -> as an interface
  // .map(input)
  //  TypeMap
}
