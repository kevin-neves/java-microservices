package com.ecommerce.shopvalidator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    @JsonProperty("customer_uuid")
    private UUID customerUuid;

    private String name;
    private String address;
    private String cpf;
    private String email;
}
