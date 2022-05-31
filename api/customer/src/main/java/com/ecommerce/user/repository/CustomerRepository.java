package com.ecommerce.user.repository;

import com.ecommerce.user.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("customer")
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByCpf(String cpf);
}
