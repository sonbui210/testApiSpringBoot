package com.example.demoapitest.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "brands")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brandID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "deleted")
    private Boolean deleted;


    //test github 1
}
