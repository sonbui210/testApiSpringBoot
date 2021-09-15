package com.example.demoapitest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "prodcuts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private float price;

    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
