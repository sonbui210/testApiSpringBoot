package com.example.demoapitest.entities;


import lombok.Data;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Data
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testId;

    @Column(name = "a")
    private int a;


    @Column(name = "b")
    private int b;

    @Column(name = "tong")
    private int tong;
}
