package com.zup.ecommerce_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class ClientDTO {
    @NotBlank(message = "Por favor, digite um nome.")
    private String name;

    @NotBlank(message = "Por favor, digite um CPF.")
    private String cpf;

    @Email
    private String email;

    public ClientDTO(String cpf, String email, String name) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
