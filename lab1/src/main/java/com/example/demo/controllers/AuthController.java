package com.example.demo.controllers;

import com.example.demo.Dtos.AuthRequest;
import com.example.demo.Dtos.AuthResponse;
import com.example.demo.Dtos.Roles;
import com.example.demo.config.Jwt.JwtUtil;
import com.example.demo.config.PasswordUtil;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    @Autowired

    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<Users> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
        else if (PasswordUtil.verifyPassword(password, user.get().getPassword_user())) {
            String token = jwtUtil.generateToken(email, user.get().getRole(), user.get().getStoreU_id(), user.get().getName_user());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Roles role = request.getRole();
        String username= request.getName_user();
        Optional<Users> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            userService.createUser(email, password, role, username);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente. Ahora debe iniciar sesión.");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ya registrado");
        }
    }
}



