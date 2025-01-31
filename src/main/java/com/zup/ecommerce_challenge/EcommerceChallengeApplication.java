package com.zup.ecommerce_challenge;

import com.zup.ecommerce_challenge.model.Client;
import com.zup.ecommerce_challenge.model.Product;
import com.zup.ecommerce_challenge.model.Purchase;
import com.zup.ecommerce_challenge.repository.ClientRepository;
import com.zup.ecommerce_challenge.repository.ProductRepository;
import com.zup.ecommerce_challenge.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EcommerceChallengeApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(EcommerceChallengeApplication.class, args);
	}

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public void run(String... args) throws Exception {
		Client client = new Client(null, "Luis", "12345678909", "luis.lago@email.com");
		clientRepository.save(client);
		Product product = new Product(null, "Camisa", 25.00, 20);
		productRepository.save(product);
		List<Product> products = new ArrayList<>();
		products.add(product);
		Purchase purchase = new Purchase(client, products);
		purchaseRepository.save(purchase);
	}
}
