package com.ecommerce.shopvalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ShopValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopValidatorApplication.class, args);
    }

}
