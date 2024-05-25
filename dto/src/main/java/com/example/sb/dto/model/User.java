package com.example.sb.dto.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class User {
  private int id;
  private List<Stock> stocks;

   public User(){
    this.id++ ;
    stocks = new ArrayList<>();
   }
   public void add(Stock stock){
    this.stocks.add(stock);
   }
  }
  

