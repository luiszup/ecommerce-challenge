package com.zup.ecommerce_challenge.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDTO {

    @NotBlank(message = "Por favor, digite o nome do produto.")
    private String name;

    @NotBlank(message = "Por favor, digite um preço.")
    @DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que 0.")
    private Double price;

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
