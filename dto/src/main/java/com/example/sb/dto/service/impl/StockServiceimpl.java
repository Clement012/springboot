package com.example.sb.dto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sb.dto.config.AppConfig;
import com.example.sb.dto.model.Stock;
import com.example.sb.dto.service.StockService;

@Service
public class StockServiceimpl implements StockService{
  
  @Autowired
  private AppConfig appConfig;

  @Override
  public List<Stock> getAll() {
    return appConfig.getUsers().stream() //
        .flatMap(e -> e.getStocks().stream()) //
        .collect(Collectors.toList());
  }
}
