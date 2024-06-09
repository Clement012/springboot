package com.example.sb.route.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.route.controller.RouteOperation;
import com.example.sb.route.model.Route;
import com.example.sb.route.service.RouteService;

@RestController
public class RouteController implements RouteOperation{

  @Autowired
  private RouteService routeService;
  @Override
  public Route getRoute(){
    return routeService.getRoute();
  }
}
