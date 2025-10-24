package com.example.demo.services;

import com.example.demo.entities.Products;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<Products> getProductBySKU(String sku) {
        return productRepository.findBySKU(sku);
    }

    public List<Products> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public Products createProduct(Products product) {
        // Validar que el SKU no exista
        if (productRepository.findBySKU(product.getSKU()).isPresent()) {
            throw new RuntimeException("El SKU ya existe: " + product.getSKU());
        }
        
        // Validar datos requeridos
        if (product.getNombre_product() == null || product.getNombre_product().trim().isEmpty()) {
            throw new RuntimeException("El nombre del producto es requerido");
        }
        
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new RuntimeException("El precio debe ser mayor a 0");
        }
        
        if (product.getSKU() == null || product.getSKU().trim().isEmpty()) {
            throw new RuntimeException("El SKU es requerido");
        }

        productRepository.save(product);
        return product;
    }

    public Products updateProduct(Products product) {
        // Validar que el producto existe
        Products existingProduct = productRepository.findById(product.getId());
        if (existingProduct == null) {
            throw new RuntimeException("Producto no encontrado con ID: " + product.getId());
        }

        // Validar que el SKU no esté duplicado (si cambió)
        if (!existingProduct.getSKU().equals(product.getSKU())) {
            if (productRepository.findBySKU(product.getSKU()).isPresent()) {
                throw new RuntimeException("El SKU ya existe: " + product.getSKU());
            }
        }

        // Validar datos requeridos
        if (product.getNombre_product() == null || product.getNombre_product().trim().isEmpty()) {
            throw new RuntimeException("El nombre del producto es requerido");
        }
        
        if (product.getPrice() == null || product.getPrice() <= 0) {
            throw new RuntimeException("El precio debe ser mayor a 0");
        }
        
        if (product.getSKU() == null || product.getSKU().trim().isEmpty()) {
            throw new RuntimeException("El SKU es requerido");
        }

        productRepository.update(product);
        return product;
    }

    public void deleteProduct(Long id) {
        Products existingProduct = productRepository.findById(id);
        if (existingProduct == null) {
            throw new RuntimeException("Producto no encontrado con ID: " + id);
        }
        
        productRepository.delete(id);
    }

    public boolean productExists(Long id) {
        try {
            productRepository.findById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
