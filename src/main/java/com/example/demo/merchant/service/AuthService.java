package com.example.demo.merchant.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.merchant.model.Merchant;
import com.example.demo.merchant.repository.MerchantRepository;

@Service
public class AuthService {
    
    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(MerchantRepository merchantRepository, PasswordEncoder passwordEncoder){
        this.merchantRepository = merchantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Merchant login(String email, String password){
        Merchant merchant = merchantRepository.findByEmail(email)
        .orElseThrow(()->new RuntimeException("Invalid email id"));

        if(!passwordEncoder.matches(password, merchant.getPassword())){
            throw new RuntimeException("Invalid password");
        }

        return merchant;
    }
}
