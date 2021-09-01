package com.inventory.service;


import com.inventory.bean.InventoryItem;
import com.inventory.bean.InventoryItemList;
import com.inventory.persistence.InventoryDaoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryService implements InventoryServiceInterface {
    private InventoryDaoInterface inventoryDoa;

    @Autowired
    public void setInventoryDoa(InventoryDaoInterface inventoryDoa) {
        this.inventoryDoa = inventoryDoa;
    }

    @Override
    public InventoryItemList getAllInventoryItems() {
        InventoryItemList inventoryItemList = new InventoryItemList();
        inventoryItemList.setInventoryItems(inventoryDoa.findAll());
        return inventoryItemList;
    }

    @Override
    public InventoryItem insertInventoryItem(InventoryItem inventoryItem) {
        return inventoryDoa.save(inventoryItem);
    }

    @Override
    public InventoryItem getInventoryItemById(Long id) {
        return inventoryDoa.getInventoryItemById(id);
    }

    @Override
    public InventoryItem deleteInventoryItemById(Long id) {
        InventoryItem inventoryItem = getInventoryItemById(id);
        inventoryDoa.delete(inventoryItem);
        return inventoryItem;
    }


    @Override
    public InventoryItem updateInventoryItemQuantityByProductCode(String productCode, int quantity) {
        if(inventoryDoa.updateInventoryItemQuantityByProductCode(productCode,quantity) > 0){
            return inventoryDoa.getInventoryItemByProductCode(productCode);
        }
        return null;
    }
}