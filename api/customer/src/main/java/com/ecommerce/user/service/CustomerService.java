package com.ecommerce.user.service;

import com.ecommerce.user.dto.request.CustomerRequest;
import com.ecommerce.user.dto.response.CustomerResponse;
import com.ecommerce.user.model.Customer;
import com.ecommerce.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }

    public CustomerResponse createUser(CustomerRequest customerRequest) {
        Customer user = CustomerRequest.createFromRequest(customerRequest);
        customerRepository.save(user);
        return new CustomerResponse(user);
    }

    public Customer getCustomerByCpf(String cpf) {
        return customerRepository.findByCpf(cpf);
    }
}
