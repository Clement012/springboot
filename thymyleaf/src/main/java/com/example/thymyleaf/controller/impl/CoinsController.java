package com.example.thymyleaf.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.thymyleaf.controller.CoinsOperation;
import com.example.thymyleaf.model.CoinData;
import com.example.thymyleaf.service.CoinService;

@RestController
public class CoinsController implements CoinsOperation {

  @Autowired
  private CoinService coinService;

  @Override
  public List<CoinData> getCoinData(){
    return coinService.getCoinData();
  }
}
