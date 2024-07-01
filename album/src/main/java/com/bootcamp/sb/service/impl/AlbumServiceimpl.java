package com.bootcamp.sb.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.sb.infra.Scheme;
import com.bootcamp.sb.model.Album;
import com.bootcamp.sb.repository.AlbumRepository;
import com.bootcamp.sb.mapper.AlbumEntityMapper;
import com.bootcamp.sb.service.AlbumService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AlbumServiceimpl implements AlbumService{

  @Value(value = "${api.json-place-holder.domain}") 
  private String domain;

  @Value(value = "${api.json-place-holder.endpoints.albums}")
  private String albumEndpoint;
  
  @Autowired
  private RestTemplate restTemplate; //Step3

  @Autowired
  private AlbumRepository albumRepository;

  @Autowired
  private AlbumEntityMapper albumEntityMapper;
  
  @Override 
  public List<Album> getAlbums(){  //Step 2
      String url = UriComponentsBuilder.newInstance()
         .scheme(Scheme.HTTPS.lowerCase())
         .host(this.domain)
         .path(albumEndpoint)
         .toUriString();
         log.info("url : "+url);  //System.out.println
      Album[] albums = restTemplate.getForObject(url, Album[].class);

    return Arrays.asList(albums);
  }
 //public List<Album> getAlbums(){ //Step 1
 //   String url = "https://jsonplaceholder.typicode.com/albums";
 //   Album[] albums = new RestTemplate().getForObject(url, Album[].class);

  //  return Arrays.asList(albums);
 // }

  @Override
  public void saveAlbum(){
    getAlbums().stream()
     .map(a -> albumEntityMapper.map(a))
     .forEach(a -> albumRepository.save(a));
  }

}
