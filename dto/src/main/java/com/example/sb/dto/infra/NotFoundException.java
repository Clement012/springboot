package com.example.sb.dto.infra;

public class NotFoundException extends BusinessException {
  
  public NotFoundException(){
    super(Syscode.NOT_FOUND);
  }
}
