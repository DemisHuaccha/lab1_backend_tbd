package com.example.demo.services;

import com.example.demo.Dtos.Roles;
import com.example.demo.config.PasswordUtil;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<Users> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void createUser(String email, String password) {
        Users user = new Users();
        user.setEmail_user(email);
        user.setPassword_user(PasswordUtil.hashPassword(password));
        user.setRol(Roles.CLIENTE);
        userRepository.save(user);
    }

    public void updateUser(Users user) {
        user.setPassword_user(PasswordUtil.hashPassword(user.getPassword_user()));
        userRepository.update(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }


}
