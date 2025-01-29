package com.zup.ecommerce_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProductDTO {

    @Column(unique = true)
    @NotNull(message = "O nome do produto não pode ser nulo.")
    @NotBlank(message = "Por favor, digite o nome do produto.")
    private String name;

    @NotNull(message = "O preço não pode ser nulo.")
    @NotBlank(message = "Por favor, digite um preço.")
    @DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que 0.")
    private Double price;

    @NotNull(message = "A quantidade de estoque não pode ser nula.")
    @NotBlank(message = "A quantidade em estoque é obrigatória e não pode estar vazia.")
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private int quantity;

    public ProductDTO(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
