package org.example.msecommerce.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.msecommerce.enums.ProductStatusEnum;

import java.math.BigDecimal;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "products")

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;
    private String category;
    private  Integer stock;
    @Enumerated(EnumType.STRING)
    private ProductStatusEnum status=ProductStatusEnum.ACTIVE;
}
