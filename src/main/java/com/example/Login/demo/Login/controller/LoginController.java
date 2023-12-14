package com.example.Login.demo.Login.controller;


//import com.example.Login.demo.Login.SecurityConfig.JwtUtil;
import com.example.Login.demo.Login.entity.Login;
import com.example.Login.demo.Login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Login")
public class LoginController {

    @Autowired
    private LoginService loginService;


//    @PostMapping("/register")
//    public Login Login(@RequestBody Login login) {
//        return loginService.Login(login);
////         return "user registered succesfully";
//
//    }

    @PostMapping("/register")
    public Login registerUser(@RequestBody Login login) {
        return loginService.registerUser(login);
    }



    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        if (loginService.loginUser(email, password)) {

            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

}


