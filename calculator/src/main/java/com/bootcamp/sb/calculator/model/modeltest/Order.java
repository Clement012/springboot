package com.bootcamp.sb.calculator.model.modeltest;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Order {
  private int id;
  public List<Address> address;
}
