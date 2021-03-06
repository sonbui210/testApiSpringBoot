package com.example.demoapitest.entities;


import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int quantity;

//    @JsonIgnore
//    @OneToMany(mappedBy = "category")
//    private Set<Product> products;

}
