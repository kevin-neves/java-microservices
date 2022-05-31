package com.ecommerce.product.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_code")
    @GeneratedValue
    private UUID productUuid;

    @Column(name = "product_description")
    private String description;

    @Column(name = "store_price")
    private Float price;

    @Column(name = "in_stock")
    private Boolean inStock;

    @Column(name = "product_size")
    private String size;

    @Column(name = "product_color")
    private String color;

    @Column(name = "product_brand")
    private String brand;

    @Column(name = "product_quantity")
    private Integer quantity;
}
