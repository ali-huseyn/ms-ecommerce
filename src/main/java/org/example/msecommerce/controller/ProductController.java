package org.example.msecommerce.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.msecommerce.dto.DummyProductResponseDto;
import org.example.msecommerce.dto.DummyProductsResponseDto;
import org.example.msecommerce.dto.ProductRequestDto;
import org.example.msecommerce.dto.ProductResponseDto;
import org.example.msecommerce.entity.ProductEntity;
import org.example.msecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody @Valid ProductRequestDto productRequestDto) {
        productService.createProduct(productRequestDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getProduct(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateProduct(@PathVariable Long id, @RequestBody @Valid ProductRequestDto productRequestDto) {
        productService.updateProduct(id, productRequestDto);
    }
    @GetMapping("/external")
    @ResponseStatus(HttpStatus.OK)
    public DummyProductsResponseDto getExternalProducts() {
      return   productService.getExternalProducts();
    }

    @GetMapping("/external/async")
    public DummyProductsResponseDto getExternalProductsAsync() {
        return productService.getExternalProductsAsync();
    }




}
