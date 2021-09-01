package com.inventory.service;

import com.inventory.bean.InventoryItem;
import com.inventory.bean.InventoryItemList;


public interface InventoryServiceInterface {

    InventoryItemList getAllInventoryItems();
    InventoryItem insertInventoryItem(InventoryItem inventoryItem);
    InventoryItem getInventoryItemById(Long id);
    InventoryItem deleteInventoryItemById(Long id);
    InventoryItem updateInventoryItemQuantityByProductCode(String productCode, int quantity);
}