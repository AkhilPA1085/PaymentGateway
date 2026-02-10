package com.example.demo.merchant.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.merchant.model.Merchant;
import com.example.demo.merchant.repository.MerchantRepository;

@Service
public class MerchantService {
    
    private final MerchantRepository merchantRepository;
    private final PasswordEncoder passwordEncoder;

    public MerchantService(MerchantRepository merchantRepository, PasswordEncoder passwordEncoder){
        this.merchantRepository = merchantRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Merchant create(Merchant merchant){
        if(merchantRepository.existsByEmail(merchant.getEmail())){
            throw new RuntimeException("Merchant already exists");
        }
        merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
        merchant.setApiKey("m_Key"+System.currentTimeMillis());
        return merchantRepository.save(merchant);
    }


}
