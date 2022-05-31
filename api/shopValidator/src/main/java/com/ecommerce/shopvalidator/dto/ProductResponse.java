package com.ecommerce.shopvalidator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID productUuid;
    private String name;
    private String description;
    private Double price;
    private Boolean inStock;
    private String size;
    private String color;
    private String brand;
    private Integer quantity;

}
