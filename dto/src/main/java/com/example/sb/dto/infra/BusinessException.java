package com.example.sb.dto.infra;

import lombok.Getter;

@Getter
public class BusinessException extends Exception {
  
  private int code;

  public BusinessException(Syscode sysCode){
    super(sysCode.getDesc());
    this.code = sysCode.getCode();
  }
}
