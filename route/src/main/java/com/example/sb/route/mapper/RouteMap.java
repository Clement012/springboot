package com.example.sb.route.mapper;

import org.springframework.stereotype.Component;
import com.example.sb.route.dto.RouteDTO;
import com.example.sb.route.dto.RouteDTO.DataDTO;
import com.example.sb.route.model.Route;

// Component
public class RouteMap {
  /* 
  public RouteDTO map(Route route){

     DataDTO dataDTO = DataDTO.builder()
       .route(route.getData().getRoute())
       .bound(route.getData().getBound())
       .originalEnglishName(route.getData().getOriginalEnglishName())
       .originalCantoneseName(route.getData().getOriginalCantoneseName())
       .destinationEnglishName(route.getData().getDestinationEnglishName())
       .destinationCantoneseName(route.getData()).getDestinationCantoneseName()
       .build();
    
    return RouteDTO.builder()
       .type(route.getType())
       .version(route.getVersion())
       .data(dataDTO)
       .build();
  } */
}
