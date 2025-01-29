package com.zup.ecommerce_challenge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

@Entity
public class Product {

    @Column(unique = true)
    private String name;

    @DecimalMin(value = "0.01", message = "O preço do produto deve ser maior que 0.")
    private Double price;

    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0.")
    private int quantity;

    public Product(String name, Double price, int quantity) {
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
