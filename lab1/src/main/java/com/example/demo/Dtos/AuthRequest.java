package com.example.demo.Dtos;

public class AuthRequest {
    private String email;
    private String password;
    private Roles role;

    //Getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Roles getRole() {
        return role;
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRol(Roles role) {
        this.role = role;
    }
}
