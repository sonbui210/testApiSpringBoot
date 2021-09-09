package com.example.demoapitest.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

   // @Temporal(TemporalType.DATE)
    //@Column(name = "orderdate")
    //private Date orderDate;

    //@Column(name = "amount")
    //private double amount;

    @Column(name = "status")
    private String status;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
