package com.example.demoapitest.controller;


import com.example.demoapitest.entities.Customer;
import com.example.demoapitest.service.CustomerService;
import com.example.demoapitest.service.ServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1")
@PreAuthorize("hasRole('USER') and hasRole('MODERATOR')")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

        // get all customer
    @GetMapping("/customers")
    public ResponseEntity<ServiceResult> findAllCustomer() {
        return new ResponseEntity<ServiceResult>(customerService.findAll(), HttpStatus.OK);
    }

    //get customer theo id
    @GetMapping("/customers/{id}")
    public ResponseEntity<ServiceResult> findById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(customerService.findById(id), HttpStatus.OK);
    }

    //Create customer
    @PostMapping("/customers")
    public ResponseEntity<ServiceResult> create(@RequestBody Customer customer) {
        return new ResponseEntity<ServiceResult>(customerService.create(customer), HttpStatus.OK);
    }

    //Update customer
    @PutMapping("/customers")
    public ResponseEntity<ServiceResult> update(@RequestBody Customer customer) {
        return new ResponseEntity<ServiceResult>(customerService.update(customer), HttpStatus.OK);
    }

    @DeleteMapping("/customers")
    public ResponseEntity<ServiceResult> delete(@RequestBody DeleteCustomerRequest request) {
        return new ResponseEntity<ServiceResult>(customerService.delete(request.getId()), HttpStatus.OK);
    }

}
