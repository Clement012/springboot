package com.example.sb.bc_forum.exceptions;

import com.example.sb.bc_forum.infra.BusinessRuntimeException;
import com.example.sb.bc_forum.infra.SysCode;

public class NotFoundException extends BusinessRuntimeException{
  
  public NotFoundException() {
    super(SysCode.NOT_FOUND);
  }
}
