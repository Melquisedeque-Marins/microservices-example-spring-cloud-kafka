package com.melck.inventoryservice.controller;

import com.melck.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public boolean isInStock(@RequestParam List<String> skuCode) {
        return inventoryService.findBySkuCode().;
    }
}
