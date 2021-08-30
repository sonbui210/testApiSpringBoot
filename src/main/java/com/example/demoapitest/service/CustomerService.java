package com.example.demoapitest.service;


import com.example.demoapitest.entities.Customer;
import com.example.demoapitest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepo;

    public ServiceResult findAll() {
        ServiceResult result = new ServiceResult();
        result.setData(customerRepo.findAll());
        return result;
    }

    public ServiceResult findById(int id) {
        ServiceResult result = new ServiceResult();
        Customer customer = customerRepo.findById(id).orElse(null);
        result.setData(customer);
        return result;
    }

    public ServiceResult create(Customer customer) {
        ServiceResult result = new ServiceResult();
        result.setData(customerRepo.save(customer));
        result.setMessage("Customer created!");
        return result;
    }


    public ServiceResult update(Customer customer) {
        ServiceResult result = new ServiceResult();

        if (!customerRepo.findById(customer.getId()).isPresent()) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer not found");
        } else {
            result.setData(customerRepo.save(customer));
            result.setMessage("Create success!");
        }
        return result;
    }

    public ServiceResult delete(int id) {
        ServiceResult result = new ServiceResult();

        Customer customer = customerRepo.findById(id).orElse(null);
        if (customer == null) {
            result.setStatus(ServiceResult.Status.FAILED);
            result.setMessage("Customer not found");
        } else {
            customerRepo.delete(customer);
            result.setMessage("Delete success!");
        }
        return result;
    }

}
