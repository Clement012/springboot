package com.example.thymyleaf.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.thymyleaf.model.CoinData;

public interface CoinsOperation {
  
  @GetMapping(value = "/allcoindata")
  List<CoinData> getCoinData();
}
