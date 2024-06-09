package com.example.sb.exercise.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.exercise.controller.ExerciseController;
import com.example.sb.exercise.dto.Calculation;
import com.example.sb.exercise.service.ExerciseService;


@RestController
public class ExerciseControllerimpl implements ExerciseController {
 
   @Autowired
   private ExerciseService exerciseService;
  
   @Override
   public Calculation calculate(String x, String y, String operation){ 
     return exerciseService.calculate(x, y, operation);

  }
 }

