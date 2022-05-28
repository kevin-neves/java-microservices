package com.ecommerce.user.dto.request;

import com.ecommerce.user.model.Customer;
import com.ecommerce.user.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NonNull
public class CustomerRequest {
    private String name;
    private String address;
    private String cpf;
    private String email;

    public static Customer createFromRequest(CustomerRequest customerRequest) {
        Customer customer = new Customer(
                customerRequest.getName(),
                UUID.randomUUID(),
                customerRequest.getAddress(),
                customerRequest.getCpf(),
                customerRequest.getEmail());
        return customer;
    }
}
