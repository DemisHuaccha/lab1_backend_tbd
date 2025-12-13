package com.example.demo.controllers;

import com.example.demo.entities.Users;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/UsersByStore/{id_storeU}")
    public List<Users> getUsersByStore(@PathVariable Long id_storeU) {return userService.getUsersByIdStore(id_storeU);}

    @GetMapping("/FindByNameAndStore")
    public List<Users> findByNameAndStore(@RequestParam Long id_storeU, @RequestParam String name_user) {
        return userService.getUsersByStoreAndNameUser(id_storeU, name_user);
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody Users user) {
        userService.updateUser(user);
        return ResponseEntity.ok("Usuario actualizado");
    }

}
