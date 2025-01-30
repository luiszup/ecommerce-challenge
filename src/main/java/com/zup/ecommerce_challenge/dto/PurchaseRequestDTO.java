package com.zup.ecommerce_challenge.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PurchaseRequestDTO {
    @NotBlank(message = "O CPF não pode estar vazio.")
    private String cpf;

    private List<ProductNameDTO> products;

    public PurchaseRequestDTO(String cpf, List<ProductNameDTO> products) {
        this.cpf = cpf;
        this.products = products;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProductNameDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductNameDTO> products) {
        this.products = products;
    }
}
