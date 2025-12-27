package com.example.coding_challenge.entity;

import jakarta.persistence.*;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private Double amount;

/*    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;*/


}
