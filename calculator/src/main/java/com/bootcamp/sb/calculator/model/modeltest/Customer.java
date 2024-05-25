package com.bootcamp.sb.calculator.model.modeltest;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class Customer {
  private String name; //name: same as the field name in JSON
  private LocalDate joinDate;
  private List<Order> orders; // <Order> no field name shown
 // private Order[] orders
}
