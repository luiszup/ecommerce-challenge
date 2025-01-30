package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.PurchaseRequestDTO;
import com.zup.ecommerce_challenge.model.Client;
import com.zup.ecommerce_challenge.model.Product;
import com.zup.ecommerce_challenge.model.Purchase;
import com.zup.ecommerce_challenge.repository.ClientRepository;
import com.zup.ecommerce_challenge.repository.ProductRepository;
import com.zup.ecommerce_challenge.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseService {
    private ClientRepository clientRepository;
    private ProductRepository productRepository;
    private PurchaseRepository purchaseRepository;

    public Purchase createPurchase(PurchaseRequestDTO purchaseRequestDTO) {
        Client client = clientRepository.findByCpf(purchaseRequestDTO.getCpf())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF " + purchaseRequestDTO.getCpf()));
        List<Product> products = purchaseRequestDTO.getProducts().stream()
                .map(productNameDTO -> productRepository.findByName(productNameDTO.getName())
                        .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + productNameDTO.getName())))
                .collect(Collectors.toList());
        for (Product product : products) {
            if (product.getQuantity() == 0) {
                throw new IllegalArgumentException("O produto " + product.getName() + " está em falta");
            }
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        }

        Purchase purchase = new Purchase(client, products);
        return purchaseRepository.save(purchase);
    }

    public Purchase getPurchaseById(Long id) {
        return purchaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compra não encontrada com o ID" + id));
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    public Purchase updatePurchase(Long id, Purchase updatedPurchase) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compra não encontrada com ID " + id));
        purchase.setClient(updatedPurchase.getClient());
        purchase.setProducts(updatedPurchase.getProducts());
        purchase.setPurchaseDate(updatedPurchase.getPurchaseDate());

        return purchaseRepository.save(updatedPurchase);
    }
}
