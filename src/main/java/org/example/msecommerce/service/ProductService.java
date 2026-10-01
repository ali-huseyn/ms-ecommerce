package org.example.msecommerce.service;

import lombok.RequiredArgsConstructor;
import org.example.msecommerce.client.ProductFeignClient;
import org.example.msecommerce.dto.DummyProductResponseDto;
import org.example.msecommerce.dto.DummyProductsResponseDto;
import org.example.msecommerce.dto.ProductRequestDto;
import org.example.msecommerce.dto.ProductResponseDto;
import org.example.msecommerce.entity.ProductEntity;
import org.example.msecommerce.enums.ProductStatusEnum;
import org.example.msecommerce.exception.ProductNotFoundException;
import org.example.msecommerce.mapping.ProductMapping;
import org.example.msecommerce.repository.ProductRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.example.msecommerce.mapping.ProductMapping.getProductEntity;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductFeignClient productFeignClient;

    public void createProduct(ProductRequestDto productRequestDto) {

        var entity = getProductEntity(productRequestDto);
        productRepository.save(entity);

    }

    public ProductEntity fetchProductById(long id) {
        var productEntity = productRepository.findById(id);

        if (productEntity.isEmpty()) {
            throw new ProductNotFoundException("Product not found");
        }
        return productEntity.get();
    }

    public ProductResponseDto getProductById(long id) {

        var productEntity = fetchProductById(id);

        return ProductMapping.getProductEntityFromResponse(productEntity);
    }

    public List<ProductResponseDto> getAllProducts() {

        var products = productRepository.findAll();

        return ProductMapping.getAllProducts(products);

    }

    public void deleteProductById(long id) {
        var productEntity = fetchProductById(id);

        productEntity.setStatus(ProductStatusEnum.INACTIVE);
        productRepository.save(productEntity);

    }

    public void updateProduct(long id, ProductRequestDto productRequestDto) {
        var productEntity = fetchProductById(id);

        var result = ProductMapping.updateProductEntityFromRequestDto(productEntity, productRequestDto);

        productRepository.save(result);

    }

    public DummyProductsResponseDto getExternalProducts() {
        return productFeignClient.getProducts();
    }

    @Async
    public DummyProductsResponseDto getExternalProductsAsync() {
        var result = productFeignClient.getProducts();
        return result;
    }

}
