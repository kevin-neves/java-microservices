package com.ecommerce.product.repository;

import com.ecommerce.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutcRepository extends JpaRepository<Product, Integer> {

    //findBuId
    Optional<Product> findById(Integer id);

}
