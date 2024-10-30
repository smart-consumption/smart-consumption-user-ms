package com.unicauca.smart_consumption.domain.product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
  private String id;
  private String name;
  private Category category;
  private Detail detail;
  private SustainabilityCriteria sustainabilityCriteria;
  private ProductStatus status;
  private double price;
}
