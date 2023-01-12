package com.melck.inventoryservice;

import com.melck.inventoryservice.model.Inventory;
import com.melck.inventoryservice.repositoty.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("computer");
			inventory.setQuantity(10);

			Inventory inventory1 = new Inventory();
			inventory.setSkuCode("freezer");
			inventory.setQuantity(5);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}
}
