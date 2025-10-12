package com.example.demo.entities;

import com.example.demo.Dtos.Roles;
import org.springframework.boot.autoconfigure.domain.EntityScan;

public class Users {
    private Long id_user;
    private String nombre_user;
    private String email_user;
    private String password_user;
    private Roles rol;

    // Getters
    public Long getId_user() { return id_user; }
    public String getNombre_user() { return nombre_user; }
    public String getEmail_user() { return email_user; }
    public String getPassword_user() { return password_user; }
    public Roles getRol() { return rol; }

    //Setters
    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }
    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }
    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }
    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }
}