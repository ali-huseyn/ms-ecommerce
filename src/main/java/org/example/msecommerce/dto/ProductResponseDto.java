package org.example.msecommerce.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.msecommerce.enums.ProductStatusEnum;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {
    private Long id;
    private String title;
    private BigDecimal price;
    private String category;
    private Integer stock;
    private ProductStatusEnum status;
}
