package com.example.sb.dto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.dto.controller.StockOperation;
import com.example.sb.dto.dto.StockDTO;
import com.example.sb.dto.infra.NotFoundException;
import com.example.sb.dto.model.Stock;
import com.example.sb.dto.service.StockService;
import com.example.sb.dto.service.impl.StockServiceimpl;

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

  @Override
  public Stock getStockById(String id) throws NotFoundException{
    // try{ 
    Stock stock = stockService.getById(Integer.parseInt(id)); // String to int
    // } catch (NotFoundException e) {
    // } catch (NumberFormatException e) {
    // }
    return stock;  // can change to one setence
   }
    @Override
    public Stock saveStock(Stock stock,int userId){
      return stockService.save(stock,userId);
    }

    // Demo ResponseEntity<>
    @GetMapping(value = "/test/{id}")
    public ResponseEntity<Stock> demoResponseEntity(@PathVariable String id){
      Stock stock = null;
      try {
      stock = new StockServiceimpl().demoResponseEntity(id);
      return ResponseEntity.ok().body(stock); //200 OK
    } catch (IllegalArgumentException e){
      return ResponseEntity.badRequest().body(new Stock(99, "ZZZZ", 0)); //400
    }
  }

}
