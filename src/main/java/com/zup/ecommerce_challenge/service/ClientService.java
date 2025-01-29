package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.model.Client;
import com.zup.ecommerce_challenge.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ProductService productService;

    public ClientService(ClientRepository clientRepository, ProductService productService) {
        this.clientRepository = clientRepository;
        this.productService = productService;
    }
}
