package com.zup.ecommerce_challenge.dto;

import jakarta.validation.constraints.NotBlank;

public class ProductNameDTO {
    @NotBlank(message = "O nome do produto não pode estar vazio.")
    private String name;

    public ProductNameDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
