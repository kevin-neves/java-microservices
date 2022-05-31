package com.ecommerce.shopcart.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopCart {

    private Integer id;
    private String cpfCustomer;
    private Double total;
    private List<Product> products;
    private String status;
}
