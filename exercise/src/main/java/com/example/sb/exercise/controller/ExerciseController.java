package com.example.sb.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.sb.exercise.dto.Calculation;
import com.example.sb.exercise.infra.InvalidInputException;
import com.example.sb.exercise.model.Operation;

public interface ExerciseController {
  @GetMapping(value = "/get")
  // @GetMapping(value = "/get/{x}/{y}/{operation}")
  public Calculation calculate(
     @RequestParam String x,
     @RequestParam String y,
     @RequestParam String operation);

   //throws InvalidInputException;
  }
