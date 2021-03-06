package com.ecommerce.user.dto.response;

import com.ecommerce.user.model.Customer;
import com.ecommerce.user.model.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {
    private UUID customerUuid;
    private String name;
    private String address;
    private String cpf;
    private String email;

    public CustomerResponse(Customer customer){
        if (customer.getCustomerUuid() != null) {
            this.customerUuid = customer.getCustomerUuid();
        }
        this.customerUuid = customer.getCustomerUuid();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.cpf = customer.getCpf();
        this.email = customer.getEmail();
    }

    public static List<CustomerResponse> toResponseList(List<Customer> customers){
        return  customers.stream().map(CustomerResponse::new).collect(Collectors.toList());
    }
}
