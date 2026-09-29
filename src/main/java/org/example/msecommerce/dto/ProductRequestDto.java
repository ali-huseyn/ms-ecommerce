package org.example.msecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequestDto {
    @NotBlank
    private String title;
    @NotNull
    @Min(0)
    private BigDecimal price;
    @NotBlank
    private String category;
    @NotNull
    @Min(0)
    private Integer stock;

}
