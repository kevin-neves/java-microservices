package com.ecommerce.shopcart.repository;

import com.ecommerce.shopcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
}
