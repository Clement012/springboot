package com.example.thymyleaf.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.thymyleaf.model.CoinData;

@Service
public class CoinService {
  
  @Autowired
  private RestTemplate restTemplate;

  public List<CoinData> getCoinData(){
    String url = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    CoinData[] coins = restTemplate.getForObject(url, CoinData[].class);
    return Arrays.asList(coins);
  }
}
