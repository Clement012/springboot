package com.example.sb.dto.service;


import java.util.List;
import com.example.sb.dto.infra.NotFoundException;
import com.example.sb.dto.model.Stock;

public interface StockService {
  
  public List<Stock> getAll();

  public Stock getById(int stockId) throws NotFoundException;

  Stock save(Stock stock,int userId);
} 
  

