package com.bootcamp.sb.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.sb.dto.AlbumDTO;
import com.bootcamp.sb.model.Album;

@Component
public class MapAlbum {
  
  public AlbumDTO map(Album album){
    return AlbumDTO.builder()
      .userId(album.getUserId())
      .title(album.getTitle())
      .build();
  }
}
