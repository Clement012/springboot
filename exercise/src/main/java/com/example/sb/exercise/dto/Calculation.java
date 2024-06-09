package com.example.sb.exercise.dto;

import com.example.sb.exercise.model.Operation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Calculation {
  
  private String x;
  private String y;
  private String operation;
  private String result;
  
  
}
