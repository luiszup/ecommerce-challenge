package com.zup.ecommerce_challenge.repository;

import com.zup.ecommerce_challenge.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
