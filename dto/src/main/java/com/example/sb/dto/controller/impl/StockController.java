package com.example.sb.dto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.dto.controller.StockOperation;
import com.example.sb.dto.dto.StockDTO;
import com.example.sb.dto.service.StockService;

@RestController

public class StockController implements StockOperation{
  
  // UserA : Stock5 (1000)
  // UserB : Stock5 (20000)
  // UserC : Stock10 (500)
   @Autowired
   private StockService stockService;
  // API return
  // [{"stockNo" : 5 , "quantity" : 21000}, {"stockNo : 10"}, "quantity" : 200]

   @Override
  public List<StockDTO> getStocks() {
    return stockService.getAll().stream() //
        .collect(Collectors.groupingBy(e -> e.getId(),
            Collectors.summingInt(e -> e.getQuantity()))) // Map.class
        .entrySet().stream() //
        .map(e -> new StockDTO(e.getKey(), e.getValue()))
        .collect(Collectors.toList());
  }
}
