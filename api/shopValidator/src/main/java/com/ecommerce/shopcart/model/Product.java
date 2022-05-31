package com.ecommerce.shopcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    private Integer id;
    private Integer productIdReference;
    private String name;
    private Double price;
    private Integer quantity;
}
