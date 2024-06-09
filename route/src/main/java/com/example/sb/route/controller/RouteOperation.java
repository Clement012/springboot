package com.example.sb.route.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sb.route.model.Route;

public interface RouteOperation {
  @GetMapping(value = "/getroute")
  Route getRoute();
}
