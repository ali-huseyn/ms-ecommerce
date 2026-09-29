package org.example.msecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DummyProductResponseDto {
  private Long  id;
  private String title;
  private BigDecimal price;
  private String category;
   private Integer stock;
}
