package com.ecommerce.shopvalidator.service;

import com.ecommerce.shopvalidator.dto.CustomerResponse;
import org.springframework.web.reactive.function.client.WebClient;

public class CustomerService {

    public static CustomerResponse getCustomer(String identificador) {
        WebClient webClient = WebClient.create("http://localhost:8083");

        return webClient
                .get()
                .uri("/customers/{cpf}", identificador)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }

}