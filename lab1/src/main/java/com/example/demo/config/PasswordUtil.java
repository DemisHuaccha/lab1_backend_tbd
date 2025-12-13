package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {


    public static String hashPassword(String plainPassword) {
        return plainPassword;
    }

    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return plainPassword.equals(hashedPassword);
    }
}
