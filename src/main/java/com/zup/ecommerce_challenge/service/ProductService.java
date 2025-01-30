package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.ProductDTO;
import com.zup.ecommerce_challenge.mapper.ProductMapper;
import com.zup.ecommerce_challenge.model.Product;
import com.zup.ecommerce_challenge.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = ProductMapper.convertDTOToModel(productDTO);
        Product newProduct = productRepository.save(product);
        return new ProductDTO(newProduct.getName(), newProduct.getPrice(), newProduct.getQuantity());
    }

    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID " + id));
        return ProductMapper.convertModelToDTO(product);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::convertModelToDTO)
                .collect(Collectors.toList());
    }
}
