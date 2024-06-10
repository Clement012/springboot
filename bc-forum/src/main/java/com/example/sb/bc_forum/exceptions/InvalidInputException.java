package com.example.sb.bc_forum.exceptions;

import com.example.sb.bc_forum.infra.BusinessRuntimeException;
import com.example.sb.bc_forum.infra.SysCode;

public class InvalidInputException extends BusinessRuntimeException {
  
  public InvalidInputException() {
    super(SysCode.INVALID_INPUT);
  }
}
