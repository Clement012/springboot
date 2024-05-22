package com.bootcamp.sb.calculator.controller;

import java.math.BigDecimal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class CalculatorController {
  // @PathVariable is a wat to map the variable in the URI to
    // java method input parameters
    // Approach 1  //localhost:8080/sum/10/11
    @GetMapping(value = "/sum/{a}/{b}")
    public int sum(@PathVariable(value = "a") int salary,
      @PathVariable(value = "b") int bonus){
        return salary + bonus;
      }

    // We can achieve default mapping by name,
    // if you do not explicitly define PathVaraible value
    // Approach 2 /prefer  //localhost:8080/subtract/15/12
     @GetMapping(value = "/subtract/{salary}/{bonus}")
     public int subtract(@PathVariable int salary, @PathVariable int bonus){
        return salary - bonus;
      }
     
    // //localhost:8080/multiply?a=15&b=16
      @GetMapping(value = "/multiply")
      public int multiply(@RequestParam(value = "a") int quantity,
      @RequestParam(value = "b") int price){
        return quantity * price;
      }

      //  //localhost:8080/divide?quantity=240&price=16
      @GetMapping(value = "/divide")
      public int divide(@RequestParam int quantity, @RequestParam int price){
        return quantity / price;
      }

      // //localhost:8080/sum/double?p=0.1&q=0.2 //次序有影響
      @GetMapping(value = "/sum/double")
      public double sum2(@RequestParam double p, @RequestParam double q){
        return BigDecimal.valueOf(p).add(BigDecimal.valueOf(q)).doubleValue();
      }

      @GetMapping(value = "/sum/String")
      public String sum3(@RequestParam String p, @RequestParam String q){
        double p2 = 0.0d;
        double q2 = 0.0d;
        try{
        p2 = Double.parseDouble(p);
        q2 = Double.parseDouble(p);
        } catch (NumberFormatException e){
          return "Both q and p should be numbers.";
        }
        return BigDecimal.valueOf(p2).add(BigDecimal.valueOf(q2)).toString();
      }

//  private static int[] arr = new int[]{1,2,3,4,5};
//  @GetMapping(value = "/database/value/{index}")
//  public int get(@PathVariable int index){
//    if (index >= 0 && index < arr.length){
//      return index;
//    }
//    return -1;
//  }
  public static void main(String[] args) {
    int[] array = new int[]{1,2,3,4,5};
      for (int i = 0 ; i < array.length ; i++){
        

      }
  }
}
