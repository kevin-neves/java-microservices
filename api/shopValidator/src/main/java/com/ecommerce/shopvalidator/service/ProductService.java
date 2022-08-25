package com.ecommerce.shopvalidator.service;

import com.ecommerce.shopvalidator.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductService {

    public static ProductResponse getProduto(Integer identificador, String productAdd) {
        WebClient webClient = WebClient.create(productAdd);

        return webClient
                .get()
                .uri("/products/{id}", identificador)
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .block();
    }
}
