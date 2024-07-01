package com.bootcamp.sb.mapper;

import com.bootcamp.sb.entity.AlbumEntity;
import com.bootcamp.sb.model.Album;

public class AlbumEntityMapper {
  public AlbumEntity map(Album album){
    AlbumEntity entity = new AlbumEntity();
    entity.setId(Long.valueOf(album.getId()));
    entity.setUserId(album.getUserId());
    entity.setTitle(album.getTitle());
    return entity;
  }
}
