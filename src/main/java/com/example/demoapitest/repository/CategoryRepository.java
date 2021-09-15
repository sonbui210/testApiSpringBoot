package com.example.demoapitest.repository;

import com.example.demoapitest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
