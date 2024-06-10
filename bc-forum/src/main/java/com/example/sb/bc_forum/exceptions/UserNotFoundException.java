package com.example.sb.bc_forum.exceptions;

import com.example.sb.bc_forum.infra.BusinessRuntimeException;
import com.example.sb.bc_forum.infra.SysCode;

public class UserNotFoundException extends BusinessRuntimeException {
  
  public UserNotFoundException() {
    super(SysCode.RESTTEMPLATE_ERROR);
  }

  // public NotFoundException(SysCode sysCode) {
  //   super(sysCode);
  // }

}
