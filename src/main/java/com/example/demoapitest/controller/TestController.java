package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Test;
import com.example.demoapitest.repository.TestRepository;
import com.example.demoapitest.service.ServiceResult;
import com.example.demoapitest.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("test")
    public ResponseEntity<ServiceResult> findAllTest() {
        return new ResponseEntity<ServiceResult>(testService.findAll(), HttpStatus.OK);
    }

    @GetMapping("test/{id}")
    public ResponseEntity<ServiceResult> findByIdTest(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(testService.findById(id), HttpStatus.OK);
    }

    @PostMapping("test")
    public ResponseEntity<ServiceResult> create(@RequestBody Test test) {
        return new ResponseEntity<ServiceResult>(testService.create(test), HttpStatus.OK);
    }

    @PutMapping("test")
    public ResponseEntity<ServiceResult> update(@RequestBody Test test) {
        return new ResponseEntity<ServiceResult>(testService.update(test), HttpStatus.OK);
    }

    @DeleteMapping("test/{id}")
    public ResponseEntity<ServiceResult> delete(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(testService.delele(id), HttpStatus.OK);
    }

}
