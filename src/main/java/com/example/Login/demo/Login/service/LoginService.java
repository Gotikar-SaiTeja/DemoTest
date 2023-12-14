package com.example.Login.demo.Login.service;

import com.example.Login.demo.Login.entity.Login;
import com.example.Login.demo.Login.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    public Login registerUser(Login login) {
        loginRepository.save(login);
        String message = "Registered successfully";
        return login;
    }

    public boolean loginUser(String email, String password) {
        // Retrieve user by email
        Login user = loginRepository.findByEmail(email);

        // Check if the user exists
        if (user == null) {
            return ResponseEntity.status(401).body("User not found").hasBody();
        }

        // Check if the entered password matches the stored password (plaintext comparison)
        if (password.equals(user.getPassword())) {
            return ResponseEntity.ok("Login successful").hasBody();
        } else {
            return ResponseEntity.status(401).body("Invalid password").hasBody();
        }
    }

    }




