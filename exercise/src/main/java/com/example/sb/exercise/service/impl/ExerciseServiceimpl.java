package com.example.sb.exercise.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.example.sb.exercise.dto.Calculation;
import com.example.sb.exercise.model.Operation;
import com.example.sb.exercise.service.ExerciseService;

@Service
public class ExerciseServiceimpl implements ExerciseService{

   @Override
   public Calculation calculate(String x,String y,String operation){
     double xx = Double.parseDouble(x);
     double yy = Double.parseDouble(y);
 
     BigDecimal result;
     switch (operation.toLowerCase()) {
         case "add":
             result = BigDecimal.valueOf(xx).add(BigDecimal.valueOf(yy));
             break;
         case "sub":
             result = BigDecimal.valueOf(xx).subtract(BigDecimal.valueOf(yy));
             break;
         case "mul":
             result = BigDecimal.valueOf(xx).multiply(BigDecimal.valueOf(yy));
             break;
         case "div":
             result = BigDecimal.valueOf(xx).divide(BigDecimal.valueOf(yy),5, RoundingMode.HALF_UP);
             break;
         default:
             throw new IllegalArgumentException("Invalid input");
     }
 
     return new Calculation(x, y, operation, String.valueOf(result));   
  }
}

