package com.ecommerce.shopvalidator.service;

import com.ecommerce.shopvalidator.dto.CustomerResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

public class CustomerService {


    public static CustomerResponse getCustomer(String identificador, String customerAdd) {

        WebClient webClient = WebClient.create(customerAdd);


        return webClient
                .get()
                .uri("/customers/{cpf}", identificador)
                .retrieve()
                .bodyToMono(CustomerResponse.class)
                .block();
    }
}