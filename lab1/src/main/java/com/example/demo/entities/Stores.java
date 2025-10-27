package com.example.demo.entities;

public class Stores {

    private Long id_store;
    private String nombre_store;
    private String direccion_store;
    private String ciudad_store;

    // Getters
    public Long getId_store() { return id_store; }
    public String getNombre_store() { return nombre_store; }
    public String getDireccion_store() { return direccion_store; }
    public String getCiudad_store() { return ciudad_store; }

    // Setters
    public void setId_store(Long id_store) { this.id_store = id_store;}
    public void setNombre_store(String nombre_store) {this.nombre_store = nombre_store;}
    public void setDireccion_store(String direccion_store) {this.direccion_store = direccion_store;}
    public void setCiudad_store(String ciudad_store) {this.ciudad_store = ciudad_store;}


}
