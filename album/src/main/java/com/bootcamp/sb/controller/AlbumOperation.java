package com.bootcamp.sb.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.sb.dto.AlbumDTO;
import com.bootcamp.sb.model.Album;

public interface AlbumOperation {
  @GetMapping(value = "/jsonplaceholder/albums")
  List<AlbumDTO> getAlbums();

  
}
