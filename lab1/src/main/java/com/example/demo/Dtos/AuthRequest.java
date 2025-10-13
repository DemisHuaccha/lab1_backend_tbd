package com.example.demo.Dtos;

public class AuthRequest {
    private String email;
    private String password;
    private Roles rol;

    //Getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Roles getRol() {
        return rol;
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRol(Roles rol) {
        this.rol = rol;
    }
}
