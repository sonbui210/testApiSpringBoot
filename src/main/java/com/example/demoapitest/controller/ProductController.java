package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Product;
import com.example.demoapitest.repository.ProductRepository;
import com.example.demoapitest.service.ProductService;
import com.example.demoapitest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<ServiceResult> findAll() {
        return new ResponseEntity<ServiceResult>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ServiceResult> create(@RequestBody Product product) {
        return new ResponseEntity<ServiceResult>(productService.create(product), HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<ServiceResult> update(@RequestBody Product product) {
        return new ResponseEntity<ServiceResult>(productService.update(product), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(productService.delete(id), HttpStatus.OK);
    }


}
