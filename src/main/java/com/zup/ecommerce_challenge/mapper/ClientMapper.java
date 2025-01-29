package com.zup.ecommerce_challenge.mapper;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.model.Client;

public class ClientMapper {
    public static ClientDTO convertModelToDTO(Client client) {
        return new ClientDTO(client.getName(), client.getEmail(), client.getCpf());
    }

    public static Client convertDTOtoModel(ClientDTO clientDTO) {
        if (clientDTO == null) {
            throw new IllegalArgumentException("O cliente não pode ser nulo");
        }
        return new Client(null, clientDTO.getName(), clientDTO.getCpf(), clientDTO.getEmail());
    }
}
