package com.example.sb.dto.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.sb.dto.infra.BusinessException;
import com.example.sb.dto.infra.ErrorResponse;
import com.example.sb.dto.infra.GlobalExceptionHandler;
import com.example.sb.dto.infra.NotFoundException;

@RestController
public class SelfGlobalExceptionHandler extends GlobalExceptionHandler {
  
  @ExceptionHandler(BusinessException.class)
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse notFoundExceptionHandler(NotFoundException e){
    return new ErrorResponse(e.getCode(), e.getMessage());
  }
}
