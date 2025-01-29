package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.mapper.ClientMapper;
import com.zup.ecommerce_challenge.model.Client;
import com.zup.ecommerce_challenge.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final ProductService productService;

    public ClientService(ClientRepository clientRepository, ProductService productService) {
        this.clientRepository = clientRepository;
        this.productService = productService;
    }

    public Client createClient(@Valid ClientDTO clientDTO) {
        Client client = ClientMapper.convertDTOtoModel(clientDTO);
        return clientRepository.save(client);
    }

    public List<ClientDTO> getAllClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(ClientMapper::convertModelToDTO)
                .collect(Collectors.toList());
    }
}
