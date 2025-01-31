package com.zup.ecommerce_challenge.controller;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDTO createClient(@PathVariable String cpf, @RequestBody @Valid ClientDTO clientDTO) {
        clientService.validateCpf(cpf);
        return clientService.createClient(clientDTO);
    }
}
