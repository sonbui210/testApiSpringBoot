package com.example.demoapitest.repository;


import com.example.demoapitest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
