package demo.sb.restful.exceptions;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import demo.sb.restful.infra.GlobalExceptionHandler;

@RestControllerAdvice
public class LocalExceptionHandler extends GlobalExceptionHandler{
  
}
