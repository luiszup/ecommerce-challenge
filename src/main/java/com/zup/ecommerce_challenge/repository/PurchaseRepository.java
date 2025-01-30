package com.zup.ecommerce_challenge.repository;

import com.zup.ecommerce_challenge.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
