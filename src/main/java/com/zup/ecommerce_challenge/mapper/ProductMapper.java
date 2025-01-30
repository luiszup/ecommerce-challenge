package com.zup.ecommerce_challenge.mapper;

import com.zup.ecommerce_challenge.dto.ProductDTO;
import com.zup.ecommerce_challenge.model.Product;

public class ProductMapper {
    public static ProductDTO convertModelToDTO(Product product) {
        return new ProductDTO(product.getName(), product.getPrice(), product.getQuantity());
    }

    public static Product convertDTOToModel(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo.");
        }
        return new Product(null, productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity());
    }
}
