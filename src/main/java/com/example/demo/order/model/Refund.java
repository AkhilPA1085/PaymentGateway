package com.example.demo.order.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="refunds")
public class Refund {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String refundId;

    @Column(nullable = false)
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RefundStatus refundStatus;


    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Refund(){}

    public Refund(
        String refundId,
        Long amount,
        RefundStatus refundStatus,
        LocalDateTime createdAt,
        Order order
    ){
        this.refundId= refundId;
        this.amount = amount;
        this.refundStatus = refundStatus;
        this.createdAt = createdAt;
        this.order = order;
    }

    public Long getId(){
        return id;
    }

    public String getRefundId(){
        return refundId;
    }

    public Long getAmount(){
        return amount;
    }

    public RefundStatus getRefundStatus(){
        return refundStatus;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public Order getOrder(){
        return order;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setRefundId(String refundId){
        this.refundId = refundId;
    }

    public void setAmount(Long amount){
        this.amount = amount;
    }

    public void setRefundStatus(RefundStatus refundStatus){
        this.refundStatus = refundStatus;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public void setOrder(Order order){
        this.order = order;
    }



}
