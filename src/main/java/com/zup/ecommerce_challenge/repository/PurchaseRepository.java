package com.zup.ecommerce_challenge.repository;

import com.zup.ecommerce_challenge.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Optional<Purchase> findById(Long id);
}
