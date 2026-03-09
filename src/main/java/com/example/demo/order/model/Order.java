package com.example.demo.order.model;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.merchant.model.Merchant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Table(name = "orders")
public class Order {

    @Version
    private Long version;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String orderId;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private Long refundedAmount = 0L;

    @Column(nullable = false)
    private Long capturedAmount = 0L;

    @Column(nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Refund> refunds;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public Order(){}

    public Order(String orderId, 
        Long amount, 
        String currency, 
        OrderStatus status,
        Merchant merchant, 
        LocalDateTime createdAt,
        Long refundedAmount,
        Long capturedAmount
    ){
        this.orderId = orderId;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.merchant = merchant;
        this.createdAt = createdAt;
        this.refundedAmount = refundedAmount;
        this.capturedAmount = capturedAmount;
    }

    public Long getId(){
        return id;
    }

    public String getOrderId(){
        return orderId;
    }

    public Long getAmount(){
        return amount;
    }

    public String getCurrency(){
        return currency;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public Merchant getMerchant(){
        return merchant;
    }

    public LocalDateTime getCreatedAt(){
        return createdAt;
    }

    public Long getRefundedAmount(){
        return refundedAmount;
    }

    public Long getCapturedAmount(){
        return capturedAmount;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public void setAmount(Long amount){
        this.amount = amount;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public void setStatus(OrderStatus status){
        this.status = status;
    }

    public void setMerchant(Merchant merchant){
        this.merchant = merchant;
    }

    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt = createdAt;
    }

    public void setRefundedAmount(Long refundedAmount){
        this.refundedAmount = refundedAmount;
    }

    public void setCapturedAmount(Long capturedAmount){
        this.capturedAmount = capturedAmount;
    }

}
