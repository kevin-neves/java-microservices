package com.ecommerce.product.controller;


import com.ecommerce.product.dto.request.ProductRequest;
import com.ecommerce.product.dto.response.ProductResponse;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public Page<Product> getProducts(Pageable pageable){
        return productService.listAll(pageable);
    }

    @PostMapping
    public ProductResponse postProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }


}

