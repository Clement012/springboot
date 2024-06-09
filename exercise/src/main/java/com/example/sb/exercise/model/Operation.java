package com.example.sb.exercise.model;

import lombok.Getter;

@Getter
public enum Operation {

  ADD("add"),
  SUB("sub"),
  MUL("mul"),
  DIV("div"), 
  ;

  private String input;

  private Operation(String input){
    this.input = input;
  }

  public Operation convertEnumToString(String input){
    if (input == null)
      return null;
    for (Operation operation : Operation.values()){
      if (operation.input.equalsIgnoreCase(input)){
        return operation;
      }
    } 
    throw new IllegalArgumentException();
  }
  
}
