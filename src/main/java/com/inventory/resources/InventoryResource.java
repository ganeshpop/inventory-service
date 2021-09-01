package com.inventory.resources;


import com.inventory.bean.InventoryItem;
import com.inventory.bean.InventoryItemList;
import com.inventory.service.InventoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(path = "/inventories")
public class InventoryResource {

    private InventoryServiceInterface inventoryService;

    @Autowired
    public void setInventoryService(InventoryServiceInterface inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping(produces = "Application/json")
    InventoryItemList getAllInventoryItems() {
        return inventoryService.getAllInventoryItems();
    }


    @GetMapping(path = "/{id}", produces = "Application/json")
    InventoryItem getInventoryItemById(@PathVariable("id") Long id) {
        return inventoryService.getInventoryItemById(id);
    }

    @PostMapping(produces = "Application/json", consumes = "Application/json")
    InventoryItem saveInventoryItem(@RequestBody InventoryItem inventoryItem) {
        return inventoryService.insertInventoryItem(inventoryItem);
    }

    @DeleteMapping(path = "/{id}", produces = "Application/json")
    InventoryItem deleteInventoryItemById(@PathVariable("id") Long id) {
        return inventoryService.deleteInventoryItemById(id);
    }


    @PutMapping(path = "/{productCode}/{quantity}", produces = "Application/json")
    InventoryItem updateInventoryItemQuantityByProductCode(@PathVariable("productCode") String productCode, @PathVariable("quantity") Integer quantity) {
        return inventoryService.updateInventoryItemQuantityByProductCode(productCode, quantity);
    }
}