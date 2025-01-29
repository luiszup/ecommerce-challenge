package com.zup.ecommerce_challenge.repository;

import com.zup.ecommerce_challenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
