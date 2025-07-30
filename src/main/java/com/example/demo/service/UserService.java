package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LoginRequest;
import com.example.demo.DTO.LoginResponse;
import com.example.demo.config.JwtUtil;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    JwtUtil jwtutil;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    // Create New User
    public User saveUser(User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    
    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());

        if (userOpt.isEmpty() || !passwordEncoder.matches(request.getPassword(), userOpt.get().getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        User user = userOpt.get();

        // Pass email and role to JWT util
        String token = jwtutil.generateToken(user.getEmail(), user.getRole().name());

        return new LoginResponse(token);
    }
    
    // Find all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find user by ID
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    // Delete user by ID
    public String deleteById(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User successfully deleted";
        } else {
            return "User not found with ID: " + id;
        }
    }
    
    public Optional<User> getByEmail(String email) {
    	
    	return userRepository.findByEmail(email);
    }

    // Delete all users
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users have been deleted successfully.";
    }
}
