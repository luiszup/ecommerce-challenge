package com.zup.ecommerce_challenge.mapper;

import com.zup.ecommerce_challenge.dto.ProductDTO;
import com.zup.ecommerce_challenge.model.Product;

public class ProductMapper {
    public static Product convertDTOforModel(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        return new Product(null, productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
    }
}
