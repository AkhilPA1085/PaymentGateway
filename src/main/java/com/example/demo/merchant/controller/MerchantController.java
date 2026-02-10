package com.example.demo.merchant.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.merchant.model.Merchant;
import com.example.demo.merchant.service.MerchantService;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {
    
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService){
        this.merchantService = merchantService;
    }

    @PostMapping
    public Merchant createMerchant(@RequestBody Merchant merchant){
        return merchantService.create(merchant);
    }
}
