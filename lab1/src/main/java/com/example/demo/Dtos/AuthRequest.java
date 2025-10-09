package com.example.demo.Dtos;

public class AuthRequest {
    private String email;
    private String password;

    //Getters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

    //setters
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
