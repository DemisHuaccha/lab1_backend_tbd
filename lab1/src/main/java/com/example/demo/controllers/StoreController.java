package com.example.demo.controllers;

import com.example.demo.entities.Stores;
import com.example.demo.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    //Finders

    @GetMapping
    public List<Stores> getStores(){ return storeService.getAll(); }

    @GetMapping("/{ciudad}")
    public List<Stores> getStoresByCity(@PathVariable String ciudad){ return storeService.getByCity(ciudad); }

    @GetMapping("/{id}")
    public Stores getStoreById(@PathVariable Long id){ return storeService.getById(id); }

    @GetMapping("/{name}")
    public Stores getStoreByName(@PathVariable String name){ return storeService.getByName(name); }

    @GetMapping("/{direccion}")
    public Stores getStoreByDirection(@PathVariable String direccion){ return storeService.getByDirection(direccion);}

    // Create

    @PostMapping("/create")
    public int createStore(@RequestBody Stores store){ return storeService.createStore(store); }

    // Update

    @PutMapping("/update")
    public int updateStore(@RequestBody Stores store){ return storeService.updateStore(store); }

    // Delete

    @DeleteMapping("/delete/{id}")
    public int deleteStore(@PathVariable Long id){ return storeService.deleteStore(id); }


}