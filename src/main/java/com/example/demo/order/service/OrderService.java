package com.example.demo.order.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BusinessException;
import com.example.demo.merchant.model.Merchant;
import com.example.demo.order.model.Order;
import com.example.demo.order.model.OrderStatus;
import com.example.demo.order.repository.OrderRepository;
import com.example.demo.order.repository.RefundRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
    
    private final OrderRepository orderRepository;
    private final RefundRepository refundRepository;

    public OrderService(OrderRepository orderRepository,RefundRepository refundRepository){
        this.orderRepository = orderRepository;
        this.refundRepository = refundRepository;
    }

    @Transactional
    public Order createOrder(Long amount, String currency, Merchant merchant){
        Order order = new Order();

        order.setOrderId("order_"+ UUID.randomUUID());
        order.setAmount(amount);
        order.setCurrency(currency);
        order.setStatus(OrderStatus.CREATED);
        order.setCapturedAmount(0L);
        order.setRefundedAmount(0L);
        order.setMerchant(merchant);
        order.setCreatedAt(LocalDateTime.now());

        return orderRepository.save(order);

    }

    @Transactional
    public Order authorizeOrder(String orderId){
        Order order = orderRepository.findByOrderId(orderId)
        .orElseThrow(()->new BusinessException("Order not found"));

        if(order.getStatus() != OrderStatus.CREATED){
            throw new BusinessException("Invalid State transition");
        }

        order.setStatus(OrderStatus.AUTHORIZED);

        return order;
    }

    @Transactional
    public void captureOrder(){

    }

    @Transactional
    public void refundOrder(){

    }


}
