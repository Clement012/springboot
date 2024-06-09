package com.example.sb.route.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.sb.route.model.Route;
import com.example.sb.route.service.RouteService;

@Service
public class RouteServiceImpl implements RouteService{
  
  @Autowired
  private RestTemplate restTemplate;
  
  @Override
  public Route getRoute(){
    String url = "https://data.etabus.gov.hk/v1/transport/kmb/route/";
    Route routes = restTemplate.getForObject(url, Route.class); // object
    return routes;
  }
}