package com.example.demo.services;

import com.example.demo.entities.Stores;
import com.example.demo.repositories.StoreRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    //Finders

    public List<Stores> getAll() {return storeRepository.findAll();}
    public List<Stores> getByCity(String ciudad) {return storeRepository.findByCity(ciudad);}
    public Stores getById(Long id) {return storeRepository.findById(id);}
    public Stores getByName(String name) {return storeRepository.findByName(name);}
    public Stores getByDirection(String direccion) {return storeRepository.findByDirection(direccion);}

    // Create

    public int createStore(Stores store) {return storeRepository.save(store);}

    // Update

    public int updateStore(Stores store) {return storeRepository.update(store);}

    // Delete

    public int deleteStore(Long id) {return storeRepository.delete(id);}
}
