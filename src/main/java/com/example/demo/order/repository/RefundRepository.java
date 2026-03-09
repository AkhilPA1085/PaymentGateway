package com.example.demo.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.order.model.Refund;

@Repository
public interface RefundRepository extends JpaRepository<Refund,Long>{
    
}
