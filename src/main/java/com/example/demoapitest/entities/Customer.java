package com.example.demoapitest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;


    // getter - setter
}
