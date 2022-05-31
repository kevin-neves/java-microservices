package com.ecommerce.shopcart.model;

import lombok.*;

import javax.persistence.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shop_cart")
public class ShopCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf_customer")
    private String cpfCustomer;

    @Column(name = "total_price")
    private Double total;

    @Column(name = "status")
    private String status;

    //Products
    @OneToMany(mappedBy = "shopCart", cascade = CascadeType.ALL)
    private List<Product> products;

}
