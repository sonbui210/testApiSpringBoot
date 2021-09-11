package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Order;
import com.example.demoapitest.entities.Test;
import com.example.demoapitest.service.OrderService;
import com.example.demoapitest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;

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
    public ResponseEntity<List> create(@RequestBody Test test) {
        // tong cua 2 so a va b
        int tong = test.getA() + test.getB();
        // get gia tri 2 so a va b;
        int a = test.getA();
        int b = test.getB();
        System.out.println("So a la " + a);
        System.out.println("So b la: " + b);

        //int[] uoc = null;
        //khai bao list
        List<Integer> uoc = new ArrayList<>();

        System.out.println("Danh sach cac uoc cua a + b la: ");
        for (int i = 1; i <= tong; i++) {
            if (tong % i == 0) {
               System.out.println(i);
               uoc.add(i);
            }
        }
        // tim max list cua a va b
        System.out.println("uoc lon nhat cua a + b la: " + Collections.max(uoc));
        //return new ResponseEntity<ServiceResult>(orderService.create(order), HttpStatus.OK);
        return ResponseEntity.ok(uoc);
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
