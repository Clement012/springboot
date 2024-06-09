package com.example.sb.dto.infra;

import lombok.Getter;

@Getter

public enum Syscode {
  OK(0, "success."),
  NOT_FOUND(1, "not found."),
  ;

  private int code;
  private String desc;

  private Syscode(int code,String desc){
    this.code = code;
    this.desc = desc;
  }
}
