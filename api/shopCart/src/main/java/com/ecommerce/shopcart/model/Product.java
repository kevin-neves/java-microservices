package com.ecommerce.shopcart.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id_reference")
    private Integer productIdReference;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "product_quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "shop_id")
    private ShopCart shopCart;

    public Product(Integer productIdReference, String name, Double price, Integer quantity) {
        this.productIdReference = productIdReference;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
