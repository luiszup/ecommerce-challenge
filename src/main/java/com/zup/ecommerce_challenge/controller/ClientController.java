package com.zup.ecommerce_challenge.controller;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid ClientDTO clientDTO) {
        try {
            clientService.validateCpf(clientDTO.getCpf());
            return ResponseEntity.ok(clientService.createClient(clientDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientDTO> getClientByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(clientService.getClientByCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAllClients() {
        List<ClientDTO> clients = clientService.getAllClients();
        if (clients.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable String cpf, @RequestBody @Valid ClientDTO clientDTO) {
        try {
            return ResponseEntity.ok(clientService.updateClient(cpf, clientDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cpf) {
        clientService.deleteClient(cpf);
        return ResponseEntity.noContent().build();
    }
}
