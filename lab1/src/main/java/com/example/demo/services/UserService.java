package com.example.demo.services;

import com.example.demo.Dtos.AuthRequest;
import com.example.demo.Dtos.Roles;
import com.example.demo.config.PasswordUtil;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.config.Jwt.JwtUtil;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public ResponseEntity<?> createUser(AuthRequest request) {

        String email = request.getEmail();
        String password = request.getPassword();
        Roles role = request.getRole();
        String username= request.getName_user();
        Long storeU_id = request.getStoreU_id();
        Optional<Users> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            Users new_user = new Users();
            new_user.setEmail_user(email);
            new_user.setPassword_user(PasswordUtil.hashPassword(password));
            new_user.setRole(role);
            new_user.setName_user(username);
            new_user.setStoreU_id(storeU_id);
            userRepository.save(new_user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente. Ahora debe iniciar sesión.");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Email ya registrado");
        }
    }

    public void updateUser(Users user) {
        user.setPassword_user(PasswordUtil.hashPassword(user.getPassword_user()));
        userRepository.update(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public ResponseEntity<?> verifyUser(AuthRequest request) {

        String email = request.getEmail();
        String password = request.getPassword();

        Optional<Users> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }
        else if (PasswordUtil.verifyPassword(password, user.get().getPassword_user())) {
            String token = jwtUtil.generateToken(email, user.get().getRole(), user.get().getStoreU_id(), user.get().getName_user());
            return ResponseEntity.ok(Map.of("token", token));
        }
        else if (user.get().getPassword_user().equals(password)) {
            String token = jwtUtil.generateToken(email, user.get().getRole(), user.get().getStoreU_id(), user.get().getName_user());
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }


}
