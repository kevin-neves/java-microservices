package com.ecommerce.user.controller;

import com.ecommerce.user.dto.request.CustomerRequest;
import com.ecommerce.user.dto.response.CustomerResponse;
import com.ecommerce.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController implements CustomerApi {
    private final CustomerService userService;
    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return userService.listCustomers().stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{cpf}")
    public CustomerResponse getCustomer(@PathVariable String cpf) {
        return new CustomerResponse(userService.getCustomerByCpf(cpf));
    }

    @PostMapping
    public CustomerResponse saveUser(@RequestBody CustomerRequest customerRequest) {
        return userService.createUser(customerRequest);
    }
}
