# E-Commerce Challenge

## Descrição
Este é um sistema básico de E-Commerce desenvolvido para simular o funcionamento de uma loja virtual. Ele permite o cadastro de produtos, clientes e a realização de compras, com validações e manipulação de dados para garantir a integridade do sistema.

---

## Funcionalidades

### Cadastro de Produtos
- **Campos obrigatórios**:
    - Nome (String): Não pode ser repetido.
    - Preço (Double): Deve ser maior que 0.
    - Quantidade (int): Deve ser maior ou igual a 0.
- **Regras de negócio**:
    - Não é permitido cadastrar produtos com o mesmo nome.
    - Validações de preço e quantidade.

### Cadastro de Clientes
- **Campos obrigatórios**:
    - Nome (String)
    - CPF (String): Deve ser único e válido.
    - Email (String): Deve ser único e válido.
- **Regras de negócio**:
    - Não é permitido cadastrar clientes com o mesmo CPF ou Email.
    - Validação de CPF.

### Realização de Compras
- **Formato do JSON para compra**:
  ```json
  {
    "cpf": "12345678900",
    "produtos": [
      { "nome": "Produto1" },
      { "nome": "Produto2" }
    ]
  } 
  ```
  
### Regras de negócio
O cliente é identificado pelo CPF.

A compra é registrada no sistema e a quantidade de produtos é atualizada.

Produtos com quantidade 0 não podem ser comprados.

Caso um ou mais produtos estejam em falta, a compra é rejeitada e uma mensagem de erro é retornada.

---
# Endpoints
## Produtos
### 1. GET/ produtos
Retorna a lista de todos os produtos cadastrados.

### 2. POST/ produtos
Cadastra um novo produto.

### 3. DELETE/ produtos/{id}
Deleta um produto pelo ID.

### 3. PUT/ produtos/{id}
Atualiza os dados de um produto pelo ID.

---
## Clientes
### 1. GET/ clientes/{cpf}
Retorna os dados de um cliente específico pelo CPF.

### 2. POST/ clientes
Cadastra um novo cliente.

### 3. DELETE/ clientes/{cpf}
Deleta um cliente pelo CPF.

### 3. PUT/ clientes/{cpf}
Atualiza os dados de um cliente pelo CPF.

---
## Compras
### 1. GET/ compras
Retorna a lista de todas as compras realizadas.

### 2. GET/ compras/{id}
Retorna os dados específicos de uma compra pelo ID.

### 3. POST/ compras
Registra uma nova compra e atualiza a quantidade de produtos.

### 4. DELETE/ compras/{id}
Deleta uma compra pelo ID.

### 5. PUT/ compras/{id}
Atualiza os dados de uma compra pelo ID.

---
# Regras de Negócio
### 1. Cadastro de Produtos
Nome deve ser único.

Preço deve ser maior que 0.

Quantidade deve ser maior ou igual a 0.

### 2. Cadastro de Clientes
CPF e Email devem ser únicos.

CPF deve ser válido.

### 3. Realização de Compras
Produtos com quantidade 0 não podem ser comprados.

Caso um ou mais produtos estejam em falta, a compra é rejeitada e uma mensagem de erro é retornada.

---
## Tecnologias Utilizadas
- **Java** com **Spring Boot** para desenvolvimento da API.
- **Jakarta Validation** para validações de dados.
- **JPA/Hibernate** para persistência de dados.