package com.zup.ecommerce_challenge.service;

import com.zup.ecommerce_challenge.dto.ClientDTO;
import com.zup.ecommerce_challenge.dto.ProductDTO;
import com.zup.ecommerce_challenge.dto.PurchaseRequestDTO;
import com.zup.ecommerce_challenge.dto.PurchaseResponseDTO;
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

    public PurchaseService(ClientRepository clientRepository, ProductRepository productRepository, PurchaseRepository purchaseRepository) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public PurchaseResponseDTO createPurchase(PurchaseRequestDTO purchaseRequestDTO) {
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
        Purchase savedPurchase = purchaseRepository.save(purchase);

        List<ProductDTO> productDTOS = products.stream()
                .map(product -> new ProductDTO(product.getName(), product.getPrice(), product.getQuantity()))
                .collect(Collectors.toList());

        return new PurchaseResponseDTO(savedPurchase.getId(), client.getCpf(), productDTOS);
    }

    public PurchaseResponseDTO getPurchaseById(Long id) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compra não encontrada com o ID" + id));

        List<ProductDTO> productDTOS = purchase.getProducts().stream()
                .map(product -> new ProductDTO(product.getName(), product.getPrice(), product.getQuantity()))
                .collect(Collectors.toList());

        return new PurchaseResponseDTO(purchase.getId(), purchase.getClient().getCpf(), productDTOS);
    }

    public List<PurchaseResponseDTO> getAllPurchases() {
        return purchaseRepository.findAll().stream()
                .map(purchase -> {
                    List<ProductDTO> productDTOs = purchase.getProducts().stream()
                            .map(product -> new ProductDTO(product.getName(), product.getPrice(), product.getQuantity()))
                            .collect(Collectors.toList());
                    return new PurchaseResponseDTO(purchase.getId(), purchase.getClient().getCpf(), productDTOs);
                })
                .collect(Collectors.toList());
    }

    public PurchaseResponseDTO updatePurchase(Long id, PurchaseRequestDTO purchaseRequestDTO) {
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compra não encontrada com ID " + id));
        Client client = clientRepository.findByCpf(purchaseRequestDTO.getCpf())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado com CPF " + purchaseRequestDTO.getCpf()));
        purchase.setClient(client);

       List<Product> products = purchaseRequestDTO.getProducts().stream()
               .map(productDTO -> {
                   Product product = productRepository.findByName(productDTO.getName())
                           .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + productDTO.getName()));
                   if (productDTO.getQuantity() > 0) {
                       if (product.getQuantity() < productDTO.getQuantity()) {
                           throw new IllegalArgumentException("Quantidade insuficiente para o produto " + product.getName());
                       }
                       product.setQuantity(product.getQuantity() - productDTO.getQuantity());
                       productRepository.save(product);
                   }
                   return product;
               })
               .collect(Collectors.toList());
       purchase.setProducts(products);

       Purchase updatedPurchase = purchaseRepository.save(purchase);

        List<ProductDTO> productDTOs = products.stream()
                .map(p -> new ProductDTO(p.getName(), p.getPrice(), p.getQuantity()))
                .collect(Collectors.toList());

        return new PurchaseResponseDTO(updatedPurchase.getId(), client.getCpf(), productDTOs);
    }

    public void deletePurchase(Long id) {
        if (!purchaseRepository.existsById(id)) {
            throw new IllegalArgumentException("Compra não encontrada com ID " + id);
        }
        purchaseRepository.deleteById(id);
    }
}
