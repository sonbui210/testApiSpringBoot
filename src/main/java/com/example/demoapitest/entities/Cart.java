package com.example.demoapitest.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int quantity;

    private float totalPrice;

//    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
//    private Collection<Product> products;


}
