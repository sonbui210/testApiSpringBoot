package com.example.demoapitest.repository;

import com.example.demoapitest.entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
