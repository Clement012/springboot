package com.bootcamp.sb.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.sb.controller.AlbumOperation;
import com.bootcamp.sb.dto.AlbumDTO;
import com.bootcamp.sb.mapper.MapAlbum;
import com.bootcamp.sb.model.Album;
import com.bootcamp.sb.service.AlbumService;

@RestController
public class AlbumController implements AlbumOperation{

  @Autowired
  private AlbumService albumService;

  @Autowired
  private MapAlbum mapAlbum;
  
  @Override
  public List<AlbumDTO> getAlbums(){
    //Step 1 -> get list from service
    return albumService.getAlbums().stream() 
       .map(e -> mapAlbum.map(e))
       .collect(Collectors.toList());
  };
}
