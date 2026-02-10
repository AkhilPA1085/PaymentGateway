package com.example.demo.merchant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.merchant.model.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>{
    boolean existsByEmail(String email);
    Optional<Merchant> findByEmail(String email);
}
