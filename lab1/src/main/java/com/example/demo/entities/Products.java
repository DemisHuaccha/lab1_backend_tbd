package com.example.demo.entities;

public class Products {
    private Long id;
    private String nombre_product;
    private String descripcion_product;
    private Integer price;
    private String SKU;

    // Getters
    public Long getId() { return id; }
    public String getNombre_product() { return nombre_product; }
    public String getDescripcion_product() { return descripcion_product; }
    public Integer getPrice() { return price; }
    public String getSKU() { return SKU; }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre_product(String nombre_product) {
        this.nombre_product = nombre_product;
    }
    public void setDescripcion_product(String descripcion_product) {
        this.descripcion_product = descripcion_product;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setSKU(String SKU) {
        this.SKU = SKU;
    }
}
