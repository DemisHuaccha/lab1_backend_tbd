package com.example.demo.Dtos;

public class Unusual {
    private String product_name;
    private String store_name;
    private Integer quantity;

    public Unusual(String product_name, String store_name, Integer quantity) {
        this.product_name = product_name;
        this.store_name = store_name;
        this.quantity = quantity;
    }

    //Getters
    public String getProduct_name() {
        return product_name;
    }
    public String getStore_name() {
        return store_name;
    }
    public Integer getQuantity() {
        return quantity;
    }

    //Setters
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
