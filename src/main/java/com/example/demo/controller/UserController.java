package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.DTO.LoginRequest;
import com.example.demo.DTO.LoginResponse;
import com.example.demo.DTO.RegisterResponse;
import com.example.demo.DTO.UserData;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    // Register user
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        Optional<User> existing = userService.getByEmail(user.getEmail());
        if (existing.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", "User already exists"));
        }
        
        User savedUser = userService.saveUser(user);  // should hash password internally

      RegisterResponse registerResponse= new RegisterResponse();
      registerResponse.setMessage("User Registered Sucessfully");
      
      UserData userData= new UserData(savedUser.getId(),savedUser.getUserName(),savedUser.getEmail());
      registerResponse.setUser(userData);

        return ResponseEntity.status(HttpStatus.CREATED).body(registerResponse);
    }
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest user) {
    	
    	
		return userService.login(user);
    }


    // Get user by ID
    @GetMapping("/get")
    public ResponseEntity<?> getByUserId(@RequestParam int id) {
        Optional<User> user = userService.getById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }

    // Get all users
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
