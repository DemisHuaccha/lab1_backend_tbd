package com.example.demo.services;

import com.example.demo.entities.Inventory;
import com.example.demo.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    public Optional<Inventory> getByIds(Long id_storein, Long id_productin) {
        return inventoryRepository.findByIds(id_storein, id_productin);
    }

    public int create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public int update(Inventory inventory) {
        return inventoryRepository.update(inventory);
    }

    public int delete(Long id_storein, Long id_productin) {
        return inventoryRepository.delete(id_storein, id_productin);
    }

    public List<Inventory> getByStore(Long id_storein) {
        return inventoryRepository.findByStore(id_storein);
    }

    public List<Inventory> getByProduct(Long id_productin) {
        return inventoryRepository.findByProduct(id_productin);
    }
}
