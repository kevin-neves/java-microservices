package com.ecommerce.shopvalidator.service;

import com.ecommerce.shopvalidator.dto.ProductResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductService {

    public static ProductResponse getProduto(Integer identificador) {
        WebClient webClient = WebClient.create("http://localhost:8082");

        return webClient
                .get()
                .uri("/products/{id}", identificador)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();
    }
}
