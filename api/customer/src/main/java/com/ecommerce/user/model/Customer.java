package com.ecommerce.user.model;


import com.ecommerce.user.dto.request.CustomerRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_code")
    @GeneratedValue
    private UUID customerUuid;

    @Column
    private String address;

    @Column
    private String cpf;

    @Column
    private String email;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Purchase> purchases;


    public Customer(String name, UUID customerUuid, String address, String cpf, String email) {
        this.name = name;
        this.customerUuid = customerUuid;
        this.address = address;
        this.cpf = cpf;
        this.email = email;
    }
}
