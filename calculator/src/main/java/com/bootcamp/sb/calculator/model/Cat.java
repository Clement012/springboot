package com.bootcamp.sb.calculator.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Cat {
  private String name;
  private int age;
  private List<Color> colors;

  }

