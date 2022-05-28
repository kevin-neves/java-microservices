package com.ecommerce.product.service;


import com.ecommerce.product.dto.request.ProductRequest;
import com.ecommerce.product.dto.response.ProductResponse;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.model.Purchase;
import com.ecommerce.product.repository.ProdutcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProdutcRepository produtcRepository;
//    private final CustomerRepository customerRepository;

    public Page<Product> listAll(Pageable pageable) {
        return produtcRepository.findAll(pageable);
    }

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .productUuid(UUID.randomUUID())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .inStock(productRequest.getInStock())
                .size(productRequest.getSize())
                .color(productRequest.getColor())
                .brand(productRequest.getBrand())
                .quantity(productRequest.getQuantity())
                .build();

        return new ProductResponse(produtcRepository.save(product));
    }

//    public List<CustomerResponse> listCustomers() { return CustomerResponse.toResponseList(customerRepository.findAll()); }
}
