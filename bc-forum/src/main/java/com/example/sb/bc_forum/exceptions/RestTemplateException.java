package com.example.sb.bc_forum.exceptions;

import com.example.sb.bc_forum.infra.BusinessRuntimeException;
import com.example.sb.bc_forum.infra.SysCode;

public class RestTemplateException extends BusinessRuntimeException {
  
  public RestTemplateException() {
    super(SysCode.RESTTEMPLATE_ERROR);
  }
}
