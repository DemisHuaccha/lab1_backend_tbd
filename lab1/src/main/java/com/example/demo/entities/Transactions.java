package com.example.demo.entities;

import java.util.Date;

public class Transactions {
    private Long id_transaction;
    private String type_transaction;
    private Date date_transaction;
    private Integer amount_product;

    // Getters
    public Long getId_transaction() { return id_transaction; }
    public String getType_transaction() { return type_transaction; }
    public Date getDate_transaction() { return date_transaction; }
    public Integer getAmount_product() { return amount_product; }

    // Setters
    public void setId_transaction(Long id_transaction) { this.id_transaction = id_transaction; }
    public void setType_transaction(String type_transaction) { this.type_transaction = type_transaction; }
    public void setDate_transaction(Date date_transaction) { this.date_transaction = date_transaction; }
    public void setAmount_product(Integer amount_product) { this.amount_product = amount_product; }
}
