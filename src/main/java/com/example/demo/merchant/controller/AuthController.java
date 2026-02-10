package com.example.demo.merchant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.merchant.DTO.LoginRequestDTO;
import com.example.demo.merchant.model.Merchant;
import com.example.demo.merchant.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/login")
    public Merchant login(@RequestBody LoginRequestDTO request){
        return authService.login(request.getEmail(),request.getPassword());
    }
}
