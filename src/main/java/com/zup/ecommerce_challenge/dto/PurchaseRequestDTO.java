package com.zup.ecommerce_challenge.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PurchaseRequestDTO {
    @NotBlank(message = "O CPF não pode estar vazio.")
    private String cpf;

    private List<ProductDTO> products;

    public PurchaseRequestDTO(String cpf, List<ProductDTO> products) {
        this.cpf = cpf;
        this.products = products;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
