package com.zup.ecommerce_challenge.dto;

import java.util.List;

public class PurchaseResponseDTO {
    private Long id;
    private String cpf;
    private List<ProductDTO> products;

    public PurchaseResponseDTO(Long id, String cpf, List<ProductDTO> products) {
        this.id = id;
        this.cpf = cpf;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
