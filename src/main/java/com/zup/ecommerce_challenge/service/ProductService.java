package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.ProductDTO;
import com.zup.ecommerce_challenge.mapper.ProductMapper;
import com.zup.ecommerce_challenge.model.Product;
import com.zup.ecommerce_challenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.convertDTOForModel(productDTO);
        Product newProduct = productRepository.save(product);
        return new ProductDTO(newProduct.getName(), newProduct.getPrice(), newProduct.getQuantity());
    }


}
