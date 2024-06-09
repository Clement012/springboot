package com.example.sb.dto.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sb.dto.config.AppConfig;
import com.example.sb.dto.infra.NotFoundException;
import com.example.sb.dto.model.Stock;
import com.example.sb.dto.model.User;
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

  @Override
  public Stock getById(int stockId) throws NotFoundException{
    return this.getAll().stream()
      .filter(e -> e.getId() == stockId)
      .findFirst()
      .orElseThrow(()-> new NotFoundException());
  }
   @Override
   public Stock save(Stock stock, int userId){
    // user id not found
    // add stock -> fail
    User user = appConfig.getUsers().stream()
         .filter(e -> e.getId() == userId)
         .findAny()
         .orElseThrow();  //exception
    if (user.add(stock))
      return stock;
    throw new RuntimeException();
  }

  public Stock demoResponseEntity(String id){
    if (id.length() == 2)
       return new Stock(1, "ABC", 2000);
    throw new IllegalArgumentException();
  }
}
