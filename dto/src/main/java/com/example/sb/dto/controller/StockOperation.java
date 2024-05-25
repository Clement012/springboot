package com.example.sb.dto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.sb.dto.dto.StockDTO;

public interface StockOperation {
  
  @GetMapping( value = "/stockTotal")
  List<StockDTO> getStocks();
}
