package com.example.sb.exercise.infra;

import lombok.Getter;

@Getter
public class InvalidInputException extends Exception{

  private int code;

  public InvalidInputException(Syscode syscode){
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }
}
