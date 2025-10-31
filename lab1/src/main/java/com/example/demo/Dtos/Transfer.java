package com.example.demo.Dtos;

public class Transfer {
    private Long id_store_origin;
    private Long id_store_destiny;
    private Long id_product;
    private Integer quantity;

    // Getters
    public Long getId_store_origin() { return id_store_origin; }
    public Long getId_store_destiny() { return id_store_destiny; }
    public Long getId_product() { return id_product; }
    public Integer getQuantity() { return quantity; }

    // Setters
    public void setId_store_origin(Long id_store_origin) { this.id_store_origin = id_store_origin; }
    public void setId_store_destiny(Long id_store_destiny) { this.id_store_destiny = id_store_destiny; }
    public void setId_product(Long id_product) { this.id_product = id_product; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
