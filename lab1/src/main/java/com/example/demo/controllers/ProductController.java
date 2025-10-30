package com.example.demo.controllers;

import com.example.demo.entities.Products;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Products product = productService.getProductById(id);
        return ResponseEntity.ok(product);

    }

    @GetMapping("/sku/{sku}")
    public ResponseEntity<Products> getProductBySKU(@PathVariable String sku) {
        Optional<Products> product = productService.getProductBySKU(sku);
        return ResponseEntity.ok(product.get());

    }

    @GetMapping("/search")
    public ResponseEntity<List<Products>> searchProductsByName(@RequestParam String name) {
        List<Products> products = productService.searchProductsByName(name);
        return ResponseEntity.ok(products);

    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Products product) {
        Products createdProduct = productService.createProduct(product);
        return ResponseEntity.ok(createdProduct);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Products product) {
        product.setId(id);
        Products updatedProduct = productService.updateProduct(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Producto eliminado correctamente");
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> productExists(@PathVariable Long id) {
        boolean exists = productService.productExists(id);
        return ResponseEntity.ok(exists);
    }
    @GetMapping("/NoMovements")
    public ResponseEntity<List<Products>> productsWithNoMovementsIn90Days() {
        List<Products> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
