package org.example.msecommerce.mapping;

import org.example.msecommerce.dto.ProductRequestDto;
import org.example.msecommerce.dto.ProductResponseDto;
import org.example.msecommerce.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public interface ProductMapping {
     static ProductEntity getProductEntity(ProductRequestDto productRequestDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(productRequestDto.getCategory());
        productEntity.setPrice(productRequestDto.getPrice());
        productEntity.setStock(productRequestDto.getStock());
        productEntity.setTitle(productRequestDto.getTitle());
        return productEntity;
    }
    static ProductResponseDto getProductEntityFromResponse(ProductEntity entity) {
        ProductResponseDto response = new ProductResponseDto();
        response.setId(entity.getId());
        response.setCategory(entity.getCategory());
        response.setPrice(entity.getPrice());
        response.setStock(entity.getStock());
        response.setTitle(entity.getTitle());
        response.setStatus(entity.getStatus());
        return response;


    }

    static List<ProductResponseDto> getAllProducts(List<ProductEntity> lists) {
           List<ProductResponseDto> responses = new ArrayList<>();


           for(ProductEntity productEntity : lists) {
               ProductResponseDto response = getProductEntityFromResponse(productEntity);
               responses.add(response);
           }
           return responses;

    }
    static ProductEntity updateProductEntityFromRequestDto(ProductEntity entity,ProductRequestDto productRequestDto) {
      entity.setCategory(productRequestDto.getCategory());
      entity.setPrice(productRequestDto.getPrice());
      entity.setStock(productRequestDto.getStock());
      entity.setTitle(productRequestDto.getTitle());

         return entity;

    }

}
