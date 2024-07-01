package com.example.thymyleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.thymyleaf.model.CoinData;
import com.example.thymyleaf.service.CoinService;

@Controller
public class CoinViewController {
  
  @Autowired
  private CoinService coinService;

  @GetMapping("/coin-data")
  public String displayCoinData(Model model){
    List<CoinData> coinDataList = coinService.getCoinData();
    model.addAttribute("coinDataList", coinDataList);
    return "coin-data";
  }

  @GetMapping("/external-data")
  public String displayExternalData(Model model){
    List<CoinData> coinDataList = coinService.getCoinData();
    model.addAttribute("coinDataList", coinDataList);
    return "external-data";
  }
}
