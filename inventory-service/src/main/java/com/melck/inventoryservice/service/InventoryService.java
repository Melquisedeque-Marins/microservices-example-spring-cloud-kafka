package com.melck.inventoryservice.service;

import com.melck.inventoryservice.repositoty.InventoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode);
    }
}
