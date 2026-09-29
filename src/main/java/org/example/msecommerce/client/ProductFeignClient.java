package org.example.msecommerce.client;

import org.example.msecommerce.dto.DummyProductResponseDto;
import org.example.msecommerce.dto.DummyProductsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-client",url = "https://dummyjson.com")
public interface ProductFeignClient {
    @GetMapping("/products")
    DummyProductsResponseDto getProducts();
    @GetMapping("/products/{id}")
    DummyProductResponseDto getProductById(@PathVariable long id);

}
