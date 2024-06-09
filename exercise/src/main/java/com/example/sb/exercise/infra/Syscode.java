package com.example.sb.exercise.infra;

import lombok.Getter;

@Getter

public enum Syscode {
  OK(0, "SUCCESS"),
  FAIL(9, "Invalid Input"),
  ;

  private int code;
  private String message;

  private Syscode(int code, String message){
    this.code = code;
    this.message = message;
  }
}
