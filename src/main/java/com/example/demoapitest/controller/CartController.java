package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Cart;
import com.example.demoapitest.service.CartService;
import com.example.demoapitest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public ResponseEntity<ServiceResult> findAllCart() {
        return new ResponseEntity<ServiceResult>(cartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/cart/{id}")
    public ResponseEntity<ServiceResult> findByIdCart(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(cartService.findById(id),HttpStatus.OK);
    }

    @PostMapping("/cart")
    public ResponseEntity<ServiceResult> createCart(@RequestBody Cart cart) {
        return new ResponseEntity<ServiceResult>(cartService.create(cart), HttpStatus.OK);
    }

    @PutMapping("/cart")
    public ResponseEntity<ServiceResult> update(@RequestBody Cart cart) {
        return new ResponseEntity<ServiceResult>(cartService.update(cart), HttpStatus.OK);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(cartService.delete(id), HttpStatus.OK);
    }

}
