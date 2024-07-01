package com.bootcamp.sb.service;

import java.util.List;
import com.bootcamp.sb.model.Album;

public interface AlbumService {
  
  List<Album> getAlbums();

  void saveAlbum();
}
