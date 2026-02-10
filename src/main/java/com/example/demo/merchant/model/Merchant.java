package com.example.demo.merchant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="merchant")
public class Merchant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String apiKey;

    public Merchant(){}

    public Merchant(String businessName, String email, String password, String apiKey ){
        this.businessName = businessName;
        this.email = email;
        this.password = password;
        this.apiKey = apiKey;
    }

    // Getter functions
    public Long getId (){
        return id;
    }

    public String getBusinessName(){
        return businessName;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getApiKey(){
        return apiKey;
    }

    // Setter functions
    public void setId(Long id){
        this.id = id;
    }

    public void setBusinessName(String businessName){
        this.businessName = businessName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setApiKey(String apiKey){
        this.apiKey = apiKey;
    }

}
