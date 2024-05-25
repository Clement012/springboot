package com.example.sb.dto.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
// DTO stands for data Transfer Object
public class StockDTO {
  private int stockNo;
  private int quantity;
}
