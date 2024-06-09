package com.example.sb.exercise.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.sb.exercise.infra.ErrorResponse;
import com.example.sb.exercise.infra.InvalidInputException;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(InvalidInputException.class)
   public ErrorResponse invalidInputExceptionHandler(InvalidInputException e){
    return new ErrorResponse(e.getCode(),e.getMessage());
   }
}
