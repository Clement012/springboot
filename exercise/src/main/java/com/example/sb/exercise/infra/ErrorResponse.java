package com.example.sb.exercise.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse {
  
  private int code;
  private String message;
}
