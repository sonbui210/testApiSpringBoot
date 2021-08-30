package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Order;
import com.example.demoapitest.service.OrderService;
import com.example.demoapitest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ResponseEntity<ServiceResult> findAllOrder() {
        return new ResponseEntity<ServiceResult>(orderService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(orderService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/orders")
    public ResponseEntity<ServiceResult> create(@RequestBody Order order) {
        return new ResponseEntity<ServiceResult>(orderService.create(order), HttpStatus.OK);
    }

    @PutMapping("/orders")
    public ResponseEntity<ServiceResult> update(@RequestBody Order order) {
        return new ResponseEntity<ServiceResult>(orderService.update(order), HttpStatus.OK);
    }

    @DeleteMapping("/orders")
    public ResponseEntity<ServiceResult> delete(@RequestBody DeleteOrderRequest request) {
        return new ResponseEntity<ServiceResult>(orderService.delete(request.getOrderId()), HttpStatus.OK);
    }
}
