package com.example.sb.dto.infra;

import java.text.NumberFormat;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.sb.dto.infra.ErrorResponse;
import com.example.sb.dto.infra.NotFoundException;
import lombok.Getter;

// Why no @ : coz its it library
// @RestControllerAdvice  // @ControllerAdvice + @ResponseBody
public class GlobalExceptionHandler {  // RunTime x7
  
  // try to catch NotFoundException
  // if it is caught, call this java method, it passes the input parameter as well.
  
  @ExceptionHandler(NumberFormatException.class)  // 7 Runtime Exception
  public ErrorResponse numberNotFoundExceptionHandler(NumberFormatException e){ // can green
    return ErrorResponse.of(ErrorCode.); //hardcode
  }

  @ExceptionHandler(ArithmeticException.class)
  public ErrorResponse illegalArgumentExceptionHandler(IllegalArgumentException e){
    return new ErrorResponse(101, "IllegalArgumentException");
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResponse arithmeticExceptionHandler(ArithmeticException e){
    return new ErrorResponse(102, "ArithmeticException");
  }

  @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
  public ErrorResponse arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e){
    return new ErrorResponse(103, "ArrayIndexOutOfBoundsException");
  }

  @ExceptionHandler(NullPointerException.class)
  public ErrorResponse nullPointerExceptionHandler(NullPointerException e){
    return new ErrorResponse(104, "NullPointerException");
  }

  @ExceptionHandler(StringIndexOutOfBoundsException.class)
  public ErrorResponse stringIndexOutOfBoundsExceptionHandler(StringIndexOutOfBoundsException e){
    return new ErrorResponse(105, "StringIndexOutOfBoundsException");
  }

  @ExceptionHandler(IllegalStateException.class)
  public ErrorResponse illegalStateExceptionHandler(IllegalStateException e){
    return new ErrorResponse(106, "IllegalStateExceptionException");
  }

  //Alternative
  

  @Getter
  private enum ErrorCode {
    IAE(100,"IllegalArgumentException"),
    AE(101,"ArithmeticException"),
    AIE(102,"ArrayIndexOutOfBoundsException"),
    NPE(103,"NullPointerException"),
    SIE(104,"StringIndexOutOfBoundsException"),
    ISE(105,"IllegalStateException"),
    NFE(106,"NumberFormatException"),
    ;
    private int code;
    private String desc;

    private Errorcode(int code,String desc){
    this.code = code;
    this.desc = desc;
    }
  }
}