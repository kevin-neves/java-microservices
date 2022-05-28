package com.ecommerce.user.controller;

import com.ecommerce.user.dto.request.CustomerRequest;
import com.ecommerce.user.dto.response.CustomerResponse;
import com.ecommerce.user.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService userService;

    @GetMapping
    public List<CustomerResponse> getCustomers() {
        return userService.listCustomers().stream().map(CustomerResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public CustomerResponse saveUser(@RequestBody CustomerRequest customerRequest) {
        return userService.createUser(customerRequest);
    }
}
