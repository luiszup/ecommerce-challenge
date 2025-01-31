package com.zup.ecommerce_challenge.controller;

import com.zup.ecommerce_challenge.dto.PurchaseRequestDTO;
import com.zup.ecommerce_challenge.dto.PurchaseResponseDTO;
import com.zup.ecommerce_challenge.service.PurchaseService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<PurchaseResponseDTO> createPurchase(@RequestBody @Valid PurchaseRequestDTO purchaseRequestDTO) {
        try {
            return ResponseEntity.ok(purchaseService.createPurchase(purchaseRequestDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseResponseDTO> getPurchaseById(@PathVariable Long id) {
        return ResponseEntity.ok(purchaseService.getPurchaseById(id));
    }
}
