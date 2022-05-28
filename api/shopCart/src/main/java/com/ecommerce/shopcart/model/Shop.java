package com.ecommerce.shopcart.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "purchase")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf_customer")
    private String cpfCustomer;

    @Column(name = "total_price")
    private Double total;

//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;

//    @ManyToMany(mappedBy = "purchases", cascade = CascadeType.ALL)
//    private List<Product> productList;
}
