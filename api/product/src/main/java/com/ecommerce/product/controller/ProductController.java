package com.ecommerce.product.controller;


import com.ecommerce.product.dto.request.ProductRequest;
import com.ecommerce.product.dto.response.ProductResponse;
import com.ecommerce.product.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@AutoConfiguration
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @Retry(name = "retry-products", fallbackMethod = "fallbackGetProducts")
    @CircuitBreaker(name = "circuit-breaker-products", fallbackMethod = "fallbackGetProducts")
    public Page<ProductResponse> getProducts(Pageable pageable){
        return productService.listAll(pageable);
    }

    @GetMapping("/{id}")
    @Retry(name = "retry-products", fallbackMethod = "fallbackGetProducts")
    @CircuitBreaker(name = "circuit-breaker-products", fallbackMethod = "fallbackGetProducts")
    public ProductResponse getProduct(@PathVariable Integer id){
        return productService.findById(id);
    }

    @PostMapping
    @CircuitBreaker(name = "circuit-breaker-products", fallbackMethod = "fallbackCreateProduct")
    public ProductResponse postProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    public Map<String, String> GetProducts(Exception ex) {
        throw new RuntimeException("Deu ruim de novo!");
    }

    public ProductResponse fallbackGetProducts(Exception ex) {
        throw new RuntimeException("Deu ruim de novo!");
    }
}

