package com.ecommerce.user.controller;

import com.ecommerce.user.dto.request.CustomerRequest;
import com.ecommerce.user.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "customer")
public interface CustomerApi {

    @RequestMapping(method = RequestMethod.GET, value = "/customers")
    List<CustomerResponse> getCustomers();

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{cpf}")
    CustomerResponse getCustomer(String cpf);
    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    CustomerResponse saveUser(CustomerRequest customerRequest);
}
